package me.karun.eodinj.http;

import me.karun.eodinj.db.model.Message;
import me.karun.eodinj.http.model.Topic;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toUnmodifiableList;

class MessageGenerator {
  static List<Message> generateMessages(final int count, final Topic topic, final LocalDate date) {
    return IntStream.rangeClosed(1, count).mapToObj(i -> message(topic, date, i)).collect(toUnmodifiableList());
  }

  private static Message message(final Topic topic, final LocalDate date, final int number) {
    return new Message(UUID.randomUUID().toString(), topic, date, "author-" + number, "update-" + number);
  }
}
