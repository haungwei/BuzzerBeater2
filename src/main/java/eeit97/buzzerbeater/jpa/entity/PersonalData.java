package eeit97.buzzerbeater.jpa.entity;

import eeit97.buzzerbeater.jpa.entity.compositeid.PersonalDataId;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by willie_chang on 2018/5/3.
 */

@Entity
@Table(name = "personaldata")
@IdClass(PersonalDataId.class)
public class PersonalData implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Players players;

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Games games;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Teams teams;

    private Integer gameTime;
    private Integer twoPoint;
    private Integer twoPointShot;
    private Integer threePoint;
    private Integer threePointShot;
    private Integer fg;
    private Integer fgShot;
    private Integer offReb;
    private Integer defReb;
    private Integer assist;
    private Integer steal;
    private Integer blocks;
    private Integer turnover;
    private Integer personalFouls;
    private Integer points;
    private Integer startingPlayer;

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    public Games getGames() {
        return games;
    }

    public void setGames(Games games) {
        this.games = games;
    }

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    public Integer getGameTime() {
        return gameTime;
    }

    public void setGameTime(Integer gameTime) {
        this.gameTime = gameTime;
    }

    public Integer getTwoPoint() {
        return twoPoint;
    }

    public void setTwoPoint(Integer twoPoint) {
        this.twoPoint = twoPoint;
    }

    public Integer getTwoPointShot() {
        return twoPointShot;
    }

    public void setTwoPointShot(Integer twoPointShot) {
        this.twoPointShot = twoPointShot;
    }

    public Integer getThreePoint() {
        return threePoint;
    }

    public void setThreePoint(Integer threePoint) {
        this.threePoint = threePoint;
    }

    public Integer getThreePointShot() {
        return threePointShot;
    }

    public void setThreePointShot(Integer threePointShot) {
        this.threePointShot = threePointShot;
    }

    public Integer getFg() {
        return fg;
    }

    public void setFg(Integer fg) {
        this.fg = fg;
    }

    public Integer getFgShot() {
        return fgShot;
    }

    public void setFgShot(Integer fgShot) {
        this.fgShot = fgShot;
    }

    public Integer getOffReb() {
        return offReb;
    }

    public void setOffReb(Integer offReb) {
        this.offReb = offReb;
    }

    public Integer getDefReb() {
        return defReb;
    }

    public void setDefReb(Integer defReb) {
        this.defReb = defReb;
    }

    public Integer getAssist() {
        return assist;
    }

    public void setAssist(Integer assist) {
        this.assist = assist;
    }

    public Integer getSteal() {
        return steal;
    }

    public void setSteal(Integer steal) {
        this.steal = steal;
    }

    public Integer getBlocks() {
        return blocks;
    }

    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    public Integer getTurnover() {
        return turnover;
    }

    public void setTurnover(Integer turnover) {
        this.turnover = turnover;
    }

    public Integer getPersonalFouls() {
        return personalFouls;
    }

    public void setPersonalFouls(Integer personalFouls) {
        this.personalFouls = personalFouls;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getStartingPlayer() {
        return startingPlayer;
    }

    public void setStartingPlayer(Integer startingPlayer) {
        this.startingPlayer = startingPlayer;
    }
}
