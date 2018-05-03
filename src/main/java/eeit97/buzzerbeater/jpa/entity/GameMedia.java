package eeit97.buzzerbeater.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by willie_chang on 2018/5/3.
 */

@Entity
@Table(name = "GAMEMEDIA")
public class GameMedia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gameMedia")
    @SequenceGenerator(name = "seq_gameMedia", sequenceName = "seq_gameMedia", allocationSize = 1)
    private Integer mediaId;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Games games;

    private String mediasName;
    private String video;
    private String photo;
    private String mediaType;
    private Timestamp mediaDate;
    private String descriptions;
    private String tag;

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public Games getGames() {
        return games;
    }

    public void setGames(Games games) {
        this.games = games;
    }

    public String getMediasName() {
        return mediasName;
    }

    public void setMediasName(String mediasName) {
        this.mediasName = mediasName;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Timestamp getMediaDate() {
        return mediaDate;
    }

    public void setMediaDate(Timestamp mediaDate) {
        this.mediaDate = mediaDate;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
