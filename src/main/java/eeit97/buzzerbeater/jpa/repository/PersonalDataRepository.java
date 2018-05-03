package eeit97.buzzerbeater.jpa.repository;

import eeit97.buzzerbeater.jpa.entity.PersonalData;
import eeit97.buzzerbeater.jpa.entity.compositeid.PersonalDataId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by willie_chang on 2018/5/3.
 */
public interface PersonalDataRepository extends JpaRepository<PersonalData, PersonalDataId> {
}
