package eeit97.buzzerbeater.jpa.repository;

import eeit97.buzzerbeater.jpa.entity.TeamsPlayers;
import eeit97.buzzerbeater.jpa.entity.compositeid.TeamsPlayersId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by willie_chang on 2018/5/3.
 */
public interface TeamsPlayersRepository extends JpaRepository<TeamsPlayers, TeamsPlayersId> {
}
