package me.karun.eodinj.http.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.karun.eodinj.db.model.Message;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMessageRequest {
  private Topic topic;
  private LocalDate date;
  private String author;
  private String message;

  public Message toMessage() {
    return new Message(UUID.randomUUID().toString(), topic, date, author, message);
  }
}
