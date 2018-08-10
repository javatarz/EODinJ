package me.karun.eodinj.db;

import me.karun.eodinj.db.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, String> {
}
