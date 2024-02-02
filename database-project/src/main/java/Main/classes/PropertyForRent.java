package Main.classes;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("3")
public class PropertyForRent extends Property{
    @Column(name = "pre_cost")
    private Long preCost;

    @Column(name = "monthly_rent")
    private Long monthlyRent;

    public PropertyForRent() {
    }
}
