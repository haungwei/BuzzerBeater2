package eeit97.buzzerbeater.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by willie_chang on 2018/5/3.
 */

@Entity
@Table(name = "groupregistration")
@IdClass(GroupRegistrationId.class)
public class GroupRegistration implements Serializable {

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

}
