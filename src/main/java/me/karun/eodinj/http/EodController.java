package me.karun.eodinj.http;

import lombok.val;
import me.karun.eodinj.db.MessageRepository;
import me.karun.eodinj.db.model.Message;
import me.karun.eodinj.http.model.CreateMessageRequest;
import me.karun.eodinj.http.model.Topic;
import me.karun.eodinj.http.model.UpdateEntryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/eod")
public class EodController {
  private final MessageRepository repository;

  private final BinaryOperator<List<Message>> joinList = (l1, l2) -> {
    val result = new ArrayList<Message>(l1);
    result.addAll(l2);
    return result;
  };

  @Autowired
  public EodController(final MessageRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  public Message create(@RequestBody CreateMessageRequest createMessageRequest) {
    return repository.save(createMessageRequest.toMessage());
  }

  @GetMapping("/{date}")
  public List<UpdateEntryResponse> fetchByDate(@PathVariable final String date) {
    return repository.findByDateOrderByTopic(LocalDate.parse(date)).stream()
      .collect(Collectors.toMap(Message::getTopic, Collections::singletonList, joinList))
      .entrySet().stream()
      .map(e -> new UpdateEntryResponse(e.getKey(), e.getValue()))
      .collect(toList());
  }

  @GetMapping("/topics")
  public List<Topic> fetchTopics() {
    return Arrays.stream(Topic.values()).collect(toList());
  }
}
