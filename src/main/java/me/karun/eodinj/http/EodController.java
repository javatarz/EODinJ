package me.karun.eodinj.http;

import me.karun.eodinj.db.MessageRepository;
import me.karun.eodinj.db.model.Message;
import me.karun.eodinj.http.model.CreateMessageRequest;
import me.karun.eodinj.http.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/eod")
public class EodController {
  private final MessageRepository repository;

  @Autowired
  public EodController(final MessageRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  public Message create(@RequestBody CreateMessageRequest createMessageRequest) {
    return repository.save(createMessageRequest.toMessage());
  }

  @GetMapping("/{date}")
  public List<Message> fetchByDate(@PathVariable final String date) {
    return repository.findByDateOrderByTopic(LocalDate.parse(date));
  }

  @GetMapping("/topics")
  public List<Topic> fetchTopics() {
    return Arrays.stream(Topic.values()).collect(toList());
  }
}

