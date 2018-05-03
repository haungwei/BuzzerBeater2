package eeit97.buzzerbeater.jpa.entity;

import java.io.Serializable;

/**
 * Created by willie_chang on 2018/5/3.
 */

public class PlayersGroupsId implements Serializable {

    private Groups groups;
    private Players players;

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }
}
