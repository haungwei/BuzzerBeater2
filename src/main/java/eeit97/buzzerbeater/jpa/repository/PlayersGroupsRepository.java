package eeit97.buzzerbeater.jpa.repository;

import eeit97.buzzerbeater.jpa.entity.PlayersGroups;
import eeit97.buzzerbeater.jpa.entity.compositeid.PlayersGroupsId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by willie_chang on 2018/5/3.
 */
public interface PlayersGroupsRepository extends JpaRepository<PlayersGroups, PlayersGroupsId> {
}
