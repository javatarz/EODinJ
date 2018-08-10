package me.karun.eodinj.http.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.karun.eodinj.db.model.Team;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTeamRequest {
  private String name;

  public Team toTeam() {
    return new Team(UUID.randomUUID().toString(), name);
  }
}
