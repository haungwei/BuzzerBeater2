package eeit97.buzzerbeater.jpa.entity;

import java.io.Serializable;

/**
 * Created by willie_chang on 2018/5/3.
 */

public class PersonalDataId implements Serializable {

    private Players players;
    private Games games;

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    public Games getGames() {
        return games;
    }

    public void setGames(Games games) {
        this.games = games;
    }
}
