package eeit97.buzzerbeater.jpa.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by willie_chang on 2018/5/2.
 */

@Entity
@Table(name = "Groups")
public class Groups implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_groups")
    @SequenceGenerator(name = "seq_groups", sequenceName = "seq_groups", allocationSize = 1)
    private Integer groupId;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Seasons seasons;

    @OneToMany(mappedBy = "groups")
    private List<Games> games;

    @OneToMany(mappedBy = "groups")
    private List<GroupsTeams> groupsTeams;

    @OneToMany(mappedBy = "groups")
    private List<PlayersGroups> playersGroups;

    private String groupName;
    private Integer maxTeams;
    private Integer minTeams;
    private Integer currentTeams;
    private Integer maxPlayers;
    private Integer minPlayers;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Seasons getSeasons() {
        return seasons;
    }

    public void setSeasons(Seasons seasons) {
        this.seasons = seasons;
    }

    public List<Games> getGames() {
        return games;
    }

    public void setGames(List<Games> games) {
        this.games = games;
    }

    public List<GroupsTeams> getGroupsTeams() {
        return groupsTeams;
    }

    public void setGroupsTeams(List<GroupsTeams> groupsTeams) {
        this.groupsTeams = groupsTeams;
    }

    public List<PlayersGroups> getPlayersGroups() {
        return playersGroups;
    }

    public void setPlayersGroups(List<PlayersGroups> playersGroups) {
        this.playersGroups = playersGroups;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getMaxTeams() {
        return maxTeams;
    }

    public void setMaxTeams(Integer maxTeams) {
        this.maxTeams = maxTeams;
    }

    public Integer getMinTeams() {
        return minTeams;
    }

    public void setMinTeams(Integer minTeams) {
        this.minTeams = minTeams;
    }

    public Integer getCurrentTeams() {
        return currentTeams;
    }

    public void setCurrentTeams(Integer currentTeams) {
        this.currentTeams = currentTeams;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Integer getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(Integer minPlayers) {
        this.minPlayers = minPlayers;
    }
}
