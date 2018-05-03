package eeit97.buzzerbeater.jpa.repository;

import eeit97.buzzerbeater.jpa.entity.Players;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by willie_chang on 2018/5/3.
 */
public interface PlayersRepository extends JpaRepository<Players, Integer> {
}
