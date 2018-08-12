package me.karun.eodinj.http.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.karun.eodinj.db.model.Message;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEntryResponse {
  private Topic topic;
  private List<Message> message;
}
