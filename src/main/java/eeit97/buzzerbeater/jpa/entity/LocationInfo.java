package eeit97.buzzerbeater.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by willie_chang on 2018/5/3.
 */

@Entity
@Table(name = "locationinfo")
public class LocationInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_locationInfo")
    @SequenceGenerator(name = "seq_locationInfo", sequenceName = "seq_locationInfo", allocationSize = 1)
    private Integer locationId;

    @OneToMany(mappedBy = "locationInfo")
    private List<Games> games;

    private String locationName;
    private String address;
    private String mark;
    private String photo;

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public List<Games> getGames() {
        return games;
    }

    public void setGames(List<Games> games) {
        this.games = games;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
