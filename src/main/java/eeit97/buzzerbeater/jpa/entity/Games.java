package eeit97.buzzerbeater.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by willie_chang on 2018/5/3.
 */

@Entity
@Table(name = "Games")
public class Games implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_games")
    @SequenceGenerator(name = "seq_games", sequenceName = "seq_games", allocationSize = 1)
    private Integer gameId;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Groups groups;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private LocationInfo locationInfo;

    @ManyToOne
    @JoinColumn(name = "team_a_id")
    private Teams teamA;

    @ManyToOne
    @JoinColumn(name = "team_b_id")
    private Teams teamB;

    @OneToMany(mappedBy = "games")
    private List<GameMedia> gameMediaList;

    @OneToMany(mappedBy = "games")
    private List<PersonalData> personalDataList;

    @Column(name = "team_a_score")
    private Integer teamAScore;

    @Column(name = "team_b_score")
    private Integer teamBScore;

    private Integer winnerId;
    private Timestamp beginDate;
    private Timestamp endDate;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public LocationInfo getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(LocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }

    public Teams getTeamA() {
        return teamA;
    }

    public void setTeamA(Teams teamA) {
        this.teamA = teamA;
    }

    public Teams getTeamB() {
        return teamB;
    }

    public void setTeamB(Teams teamB) {
        this.teamB = teamB;
    }

    public List<GameMedia> getGameMediaList() {
        return gameMediaList;
    }

    public void setGameMediaList(List<GameMedia> gameMediaList) {
        this.gameMediaList = gameMediaList;
    }

    public List<PersonalData> getPersonalDataList() {
        return personalDataList;
    }

    public void setPersonalDataList(List<PersonalData> personalDataList) {
        this.personalDataList = personalDataList;
    }

    public Integer getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(Integer teamAScore) {
        this.teamAScore = teamAScore;
    }

    public Integer getTeamBScore() {
        return teamBScore;
    }

    public void setTeamBScore(Integer teamBScore) {
        this.teamBScore = teamBScore;
    }

    public Integer getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Integer winnerId) {
        this.winnerId = winnerId;
    }

    public Timestamp getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Timestamp beginDate) {
        this.beginDate = beginDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }
}
