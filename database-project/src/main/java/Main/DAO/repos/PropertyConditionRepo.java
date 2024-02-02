package Main.DAO.repos;

import Main.classes.PropertyCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PropertyConditionRepo extends JpaRepository<PropertyCondition,Long> {

    @Modifying
    @Query("UPDATE PropertyCondition t " +
            "SET " +
            "t.cooperative = :#{#pc.cooperative}," +
            "t.barter = :#{#pc.barter}," +
            "t.convertible = :#{#pc.convertible}," +
            "t.presale = :#{#pc.presale}," +
            "t.buildingLocation = :#{#pc.buildingLocation}," +
            "t.loan = :#{#pc.loan}," +
            "t.newlyBuilt = :#{#pc.newlyBuilt}," +
            "t.equity = :#{#pc.equity}," +
            "t.shoppingCenter = :#{#pc.shoppingCenter}," +
            "t.mall = :#{#pc.mall}" +
            " WHERE t.propertyId = :#{#pc.propertyId}")
    void updatePropertyConditionFields(PropertyCondition pc);

}
