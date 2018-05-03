package eeit97.buzzerbeater.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by willie_chang on 2018/5/3.
 */

@Entity
@Table(name = "Teams")
public class Teams implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_teams")
    @SequenceGenerator(name = "seq_teams", sequenceName = "seq_teams", allocationSize = 1)
    private Integer teamId;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private LocationInfo locationInfo;

    @OneToMany(mappedBy = "teams")
    private List<TeamsPlayers> teamsPlayers;

    @OneToMany(mappedBy = "teams")
    private List<GroupsTeams> groupsTeams;

    private Integer captainId;
    private String captainEmail;
    private String captainPhone;
    private String teamName;
    private String coachName;
    private String bossName;
    private String teamBadge;
    private Integer totalWin;
    private Integer totalLose;
    private Float winRate;
    private String remarks;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public LocationInfo getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(LocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }

    public List<TeamsPlayers> getTeamsPlayers() {
        return teamsPlayers;
    }

    public void setTeamsPlayers(List<TeamsPlayers> teamsPlayers) {
        this.teamsPlayers = teamsPlayers;
    }

    public List<GroupsTeams> getGroupsTeams() {
        return groupsTeams;
    }

    public void setGroupsTeams(List<GroupsTeams> groupsTeams) {
        this.groupsTeams = groupsTeams;
    }

    public Integer getCaptainId() {
        return captainId;
    }

    public void setCaptainId(Integer captainId) {
        this.captainId = captainId;
    }

    public String getCaptainEmail() {
        return captainEmail;
    }

    public void setCaptainEmail(String captainEmail) {
        this.captainEmail = captainEmail;
    }

    public String getCaptainPhone() {
        return captainPhone;
    }

    public void setCaptainPhone(String captainPhone) {
        this.captainPhone = captainPhone;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public String getTeamBadge() {
        return teamBadge;
    }

    public void setTeamBadge(String teamBadge) {
        this.teamBadge = teamBadge;
    }

    public Integer getTotalWin() {
        return totalWin;
    }

    public void setTotalWin(Integer totalWin) {
        this.totalWin = totalWin;
    }

    public Integer getTotalLose() {
        return totalLose;
    }

    public void setTotalLose(Integer totalLose) {
        this.totalLose = totalLose;
    }

    public Float getWinRate() {
        return winRate;
    }

    public void setWinRate(Float winRate) {
        this.winRate = winRate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
