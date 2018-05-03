package eeit97.buzzerbeater;

import eeit97.buzzerbeater.jpa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private PlayersGroupsRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        repository.findAll().forEach((i) -> System.out.println(i.toString()));
    }
}
