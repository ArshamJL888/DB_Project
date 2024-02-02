package Main.classes;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "property")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="property_type",
        discriminatorType = DiscriminatorType.INTEGER)
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({ @JsonSubTypes.Type(PropertyForRent.class), @JsonSubTypes.Type(PropertyForSale.class),
        @JsonSubTypes.Type(PropertyForMortgage.class) })
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name ="property_id" )
    private Long propertyId;

    @Column(name = "title")
    private String title;

    @Column(name = "city")
    private String city;

    @Column(name = "zone")
    private String zone;

    @Column(name = "area")
    private Integer area;

    @Column(name = "usage")
    private String usage;

    @Column(name = "number_of_room")
    private Long numberOfRoom;

    @Column(name = "age")
    private Long age;

    @Column(name = "real_estate_id")
    private Long agencyID;

    @Column(name = "description")
    private String description;

    public Property() {
    }

    public Property(Long propertyId, String title, String city, String zone
            , Integer area, String usage, Long numberOfRoom, Long age, Long agencyID, String description) {
        this.propertyId = propertyId;
        this.title = title;
        this.city = city;
        this.zone = zone;
        this.area = area;
        this.usage = usage;
        this.numberOfRoom = numberOfRoom;
        this.age = age;
        this.agencyID = agencyID;
        this.description = description;
    }
}
