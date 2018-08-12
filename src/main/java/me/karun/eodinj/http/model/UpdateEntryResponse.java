package me.karun.eodinj.http.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.karun.eodinj.db.model.Message;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEntryResponse {
  private Topic topic;
  private List<Message> message;

  public UpdateEntryResponse(final Map.Entry<Topic, List<Message>> entry) {
    this(entry.getKey(), entry.getValue());
  }
}
