package eeit97.buzzerbeater.jpa.entity;

import java.io.Serializable;

/**
 * Created by willie_chang on 2018/5/3.
 */
public class GroupsTeamsId implements Serializable {

    private Teams teams;
    private Groups groups;

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
}
