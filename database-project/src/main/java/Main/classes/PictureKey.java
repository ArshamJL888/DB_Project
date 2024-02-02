package Main.classes;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Embeddable
public class PictureKey implements Serializable {
    @Column(name = "property_id")
    private Long propertyID;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "picture_id")
    private Long pictureID;

    public PictureKey(Long propertyID, Long pictureID) {
        this.propertyID = propertyID;
        this.pictureID = pictureID;
    }

    public PictureKey() {

    }

    public PictureKey(Long propertyID) {
        this.propertyID = propertyID;
    }
}
