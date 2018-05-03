package eeit97.buzzerbeater.jpa.entity;

import eeit97.buzzerbeater.jpa.entity.compositeid.PlayersGroupsId;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by willie_chang on 2018/5/3.
 */

@Entity
@IdClass(PlayersGroupsId.class)
public class PlayersGroups implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Groups groups;

    @Id
    @ManyToOne
    @JoinColumn(name = "player_id")
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
