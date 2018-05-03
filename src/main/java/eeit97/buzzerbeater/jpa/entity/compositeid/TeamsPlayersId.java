package eeit97.buzzerbeater.jpa.entity.compositeid;

import eeit97.buzzerbeater.jpa.entity.Players;
import eeit97.buzzerbeater.jpa.entity.Teams;

import java.io.Serializable;

/**
 * Created by willie_chang on 2018/5/3.
 */
public class TeamsPlayersId implements Serializable {

    private Teams teams;
    private Players players;

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }
}
