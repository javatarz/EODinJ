package me.karun.eodinj.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.karun.eodinj.http.model.Topic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
  @Id private String id;
  @Column(nullable = false) private Topic topic;
  @Column(nullable = false) private LocalDate date;
  @Column(nullable = false) private String author;
  @Column(nullable = false) private String message;
}


