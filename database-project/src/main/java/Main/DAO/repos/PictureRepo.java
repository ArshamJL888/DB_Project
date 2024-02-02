package Main.DAO.repos;

import Main.classes.Picture;
import Main.classes.PictureKey;
import Main.classes.RealStateAgency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PictureRepo extends JpaRepository<Picture, PictureKey> {

    @Query("select p  from Picture p WHERE p.pictureKey.propertyID=:propertyID ")
    List<Picture> getPicturesById(@Param(value = "propertyID") Long propertyID);
    @Query("select p  from Picture p WHERE p.pictureKey.propertyID=:propertyID and p.pictureKey.pictureID=:pictureID")
    Picture findByPictureKey(@Param(value = "propertyID")Long propertyID,@Param(value = "pictureID")Long pictureID);

    void removePictureByPictureKeyPropertyID(Long pictureID);
}
