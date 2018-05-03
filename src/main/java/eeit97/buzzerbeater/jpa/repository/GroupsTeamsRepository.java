package eeit97.buzzerbeater.jpa.repository;

import eeit97.buzzerbeater.jpa.entity.GroupsTeams;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by willie_chang on 2018/5/3.
 */
public interface GroupRegistrationRepository extends JpaRepository<GroupsTeams, Integer> {
}
