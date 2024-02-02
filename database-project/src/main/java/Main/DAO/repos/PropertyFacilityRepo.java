package Main.DAO.repos;

import Main.classes.PropertyFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

//TODO: ADD QUERY
public interface PropertyFacilityRepo extends JpaRepository<PropertyFacility,Long> {

    @Modifying
    @Query("UPDATE PropertyFacility p " +
            "SET " +
            "p.parking = :#{#pr.parking}," +
            "p.lobby = :#{#pr.lobby}," +
            "p.elevator = :#{#pr.elevator}," +
            "p.pool = :#{#pr.pool}," +
            "p.sauna = :#{#pr.sauna}," +
            "p.gym = :#{#pr.gym}," +
            "p.buildingGuard = :#{#pr.buildingGuard}," +
            "p.balcony = :#{#pr.balcony}," +
            "p.rooftopGarden = :#{#pr.rooftopGarden}," +
            "p.airCondition = :#{#pr.airCondition}," +
            "p.conferenceHall = :#{#pr.conferenceHall}," +
            "p.jacuzzi = :#{#pr.jacuzzi}," +
            "p.centralAntenna = :#{#pr.centralAntenna}," +
            "p.remoteControlledDoor = :#{#pr.remoteControlledDoor}" +
            " where p.propertyId = :#{#pr.propertyId}")
    void updatePropertyFacilityFields(PropertyFacility pr);
}
