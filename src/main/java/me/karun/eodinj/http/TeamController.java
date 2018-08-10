package me.karun.eodinj.http;

import me.karun.eodinj.db.TeamRepository;
import me.karun.eodinj.db.model.Team;
import me.karun.eodinj.http.model.CreateTeamRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
class TeamController {
  private final TeamRepository repository;

  @Autowired
  TeamController(final TeamRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  public Team create(@RequestBody CreateTeamRequest createTeamRequest) {
    return repository.save(createTeamRequest.toTeam());
  }

  @GetMapping("/{teamId}")
  public Optional<Team> fetch(@PathVariable final String teamId) {
    return repository.findById(teamId);
  }

  @GetMapping
  public List<Team> all() {
    return repository.findAll();
  }
}
