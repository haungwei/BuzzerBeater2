package eeit97.buzzerbeater;

import eeit97.buzzerbeater.jpa.entity.Season;
import eeit97.buzzerbeater.jpa.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private SeasonRepository seasonRepository;

    @Override
    public void run(String... strings) throws Exception {
        List<Season> seasonList = seasonRepository.findAll();
        seasonList.forEach(season -> System.out.println(season.toString()));
    }
}
