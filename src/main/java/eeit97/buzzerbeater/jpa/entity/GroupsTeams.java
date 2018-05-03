package eeit97.buzzerbeater.jpa.entity;

import eeit97.buzzerbeater.jpa.entity.compositeid.GroupsTeamsId;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by willie_chang on 2018/5/3.
 */

@Entity
@Table(name = "Groups_Teams")
@IdClass(GroupsTeamsId.class)
public class GroupsTeams implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Teams teams;

    @Id
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Groups groups;

    private Integer teamStat;
    private Timestamp registerDate;
    private String paymentNumber;

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public Integer getTeamStat() {
        return teamStat;
    }

    public void setTeamStat(Integer teamStat) {
        this.teamStat = teamStat;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }
}
