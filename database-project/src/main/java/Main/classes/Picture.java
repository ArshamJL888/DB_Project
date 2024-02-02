package Main.classes;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;

@Entity
@Data
@Table(name = "property_images")
@Builder
public class Picture {

    @EmbeddedId
    private PictureKey pictureKey;

    @Column(name = "photo")
    private String picture;

    @Column(name = "is_primary")
    private boolean isPrimary;

    public Picture() {

    }

    public Picture(PictureKey pictureKey, String picture, boolean isPrimary) {
        this.pictureKey = pictureKey;
        this.picture = picture;
        this.isPrimary = isPrimary;
    }

    public String getPicture() {
    return this.picture;
    }
}
