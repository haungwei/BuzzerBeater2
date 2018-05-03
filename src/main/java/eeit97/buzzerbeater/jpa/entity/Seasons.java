package eeit97.buzzerbeater.jpa.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by willie_chang on 2018/5/2.
 */

@Entity
public class Seasons implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_season")
    @SequenceGenerator(name = "seq_season", sequenceName = "seq_season", allocationSize = 1)
    private Integer seasonId;

    @OneToMany(mappedBy = "seasons")
    private List<Groups> groups;

    private String seasonName;
    private Date beginDate;
    private Date endDate;
    private Timestamp registerBeginDate;
    private Timestamp registerEndDate;
    private String descriptions;

    public Integer getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Timestamp getRegisterBeginDate() {
        return registerBeginDate;
    }

    public void setRegisterBeginDate(Timestamp registerBeginDate) {
        this.registerBeginDate = registerBeginDate;
    }

    public Timestamp getRegisterEndDate() {
        return registerEndDate;
    }

    public void setRegisterEndDate(Timestamp registerEndDate) {
        this.registerEndDate = registerEndDate;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
