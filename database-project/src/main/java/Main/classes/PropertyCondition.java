package Main.classes;// package main.classes; // Adjust the package name based on your project structure

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Property_condition")
@Data
public class PropertyCondition {
    @Id
    @Column(name = "property_id")
    private Long propertyId;

    @Column(name = "cooperative")
    private String cooperative;

    @Column(name = "barter")
    private String barter;

    @Column(name = "convertible")
    private String convertible;

    @Column(name = "presale")
    private String presale;

    @Column(name = "building_location", length = 255)
    private String buildingLocation;

    @Column(name = "loan")
    private String loan;

    @Column(name = "newly_built")
    private String newlyBuilt;

    @Column(name = "equity")
    private String equity;

    @Column(name = "shopping_center")
    private String shoppingCenter;

    @Column(name = "mall")
    private String mall;

    public PropertyCondition() {
    }

    public PropertyCondition(String cooperative, String barter, String convertible, String presale,
                             String buildingLocation, String loan, String newlyBuilt, String equity,
                             String shoppingCenter, String mall) {
        this.cooperative = cooperative;
        this.barter = barter;
        this.convertible = convertible;
        this.presale = presale;
        this.buildingLocation = buildingLocation;
        this.loan = loan;
        this.newlyBuilt = newlyBuilt;
        this.equity = equity;
        this.shoppingCenter = shoppingCenter;
        this.mall = mall;
    }

    public boolean convertStrintToBool(String variable) {
        return "1".equals(variable);
    }
}
