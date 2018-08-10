package me.karun.eodinj.db;

import me.karun.eodinj.db.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, String> {
  List<Message> findByDateOrderByTopic(final LocalDate date);
}
