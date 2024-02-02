package Main.classes;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("1")
public class PropertyForSale extends Property {

    @Column(name = "sell_cost")
    private Long sellCost;

    public PropertyForSale() {
    }
}
