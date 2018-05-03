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
@Table(name = "Season")
public class Season implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_season")
    @SequenceGenerator(name = "seq_season", sequenceName = "seq_season", allocationSize = 1)
    private Integer seasonId;

    @OneToMany(mappedBy = "season", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Groups> groups;

    private String seasonName;
    private Date beginDate;
    private Date endDate;
    private Timestamp registerBeginDate;
    private Timestamp registerEndDate;
    private String descriptions;

    @Override
    public String toString() {
        return "Season{" +
                "seasonId=" + seasonId +
                ", groups=" + groups +
                ", seasonName='" + seasonName + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", registerBeginDate=" + registerBeginDate +
                ", registerEndDate=" + registerEndDate +
                ", descriptions='" + descriptions + '\'' +
                '}';
    }
}
