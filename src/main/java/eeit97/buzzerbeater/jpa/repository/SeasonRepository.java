package eeit97.buzzerbeater.jpa.repository;

import eeit97.buzzerbeater.jpa.entity.Seasons;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by willie_chang on 2018/5/2.
 */
public interface SeasonRepository extends JpaRepository<Seasons, Integer> {
}
