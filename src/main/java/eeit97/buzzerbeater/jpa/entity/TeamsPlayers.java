package eeit97.buzzerbeater.jpa.entity;

import eeit97.buzzerbeater.jpa.entity.compositeid.TeamsPlayersId;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by willie_chang on 2018/5/3.
 */

@Entity
@IdClass(TeamsPlayersId.class)
public class TeamsPlayers implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Teams teams;

    @Id
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Players players;

    private Integer playerNumber;
    private String playerRole;
    private Timestamp joinDate;
    private Timestamp leaveDate;

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

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(String playerRole) {
        this.playerRole = playerRole;
    }

    public Timestamp getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
    }

    public Timestamp getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Timestamp leaveDate) {
        this.leaveDate = leaveDate;
    }
}
