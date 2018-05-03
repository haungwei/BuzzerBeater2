package eeit97.buzzerbeater.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by willie_chang on 2018/5/3.
 */

@Entity
@Table(name = "Players")
public class Players implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_players")
    @SequenceGenerator(name = "seq_players", sequenceName = "seq_players", allocationSize = 1)
    private Integer playerId;

    @OneToMany(mappedBy = "players")
    private List<PlayersGroups> playersGroups;

    @OneToMany(mappedBy = "players")
    private List<PersonalData> personalDataList;

    @OneToMany(mappedBy = "players")
    private List<TeamsPlayers> teamsPlayers;

    private String playerName;
    private String idCardNumber;
    private Double height;
    private Double weights;
    private Date birthday;
    private String nationality;
    private String photo;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public List<PlayersGroups> getPlayersGroups() {
        return playersGroups;
    }

    public void setPlayersGroups(List<PlayersGroups> playersGroups) {
        this.playersGroups = playersGroups;
    }

    public List<PersonalData> getPersonalDataList() {
        return personalDataList;
    }

    public void setPersonalDataList(List<PersonalData> personalDataList) {
        this.personalDataList = personalDataList;
    }

    public List<TeamsPlayers> getTeamsPlayers() {
        return teamsPlayers;
    }

    public void setTeamsPlayers(List<TeamsPlayers> teamsPlayers) {
        this.teamsPlayers = teamsPlayers;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeights() {
        return weights;
    }

    public void setWeights(Double weights) {
        this.weights = weights;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
