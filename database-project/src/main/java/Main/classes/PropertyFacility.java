package Main.classes;// package Main.classes;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "property_facility")
@Data
public class PropertyFacility {
    @Id
    @Column(name = "property_id")
    private Long propertyId;

    @Column(name = "parking")
    private String parking;

    @Column(name = "lobby")
    private String lobby;

    @Column(name = "elevator")
    private String elevator;

    @Column(name = "pool")
    private String pool;

    @Column(name = "sauna")
    private String sauna;

    @Column(name = "gym")
    private String gym;

    @Column(name = "building_guard")
    private String buildingGuard;

    @Column(name = "balcony")
    private String balcony;

    @Column(name = "rooftop_garden")
    private String rooftopGarden;

    @Column(name = "air_condition")
    private String airCondition;

    @Column(name = "conference_hall")
    private String conferenceHall;

    @Column(name = "jacuzzi")
    private String jacuzzi;

    @Column(name = "central_antenna")
    private String centralAntenna;

    @Column(name = "remote_controlled_door")
    private String remoteControlledDoor;

    public PropertyFacility() {
    }

    public PropertyFacility(String parking, String lobby, String elevator, String pool, String sauna, String gym,
                            String buildingGuard, String balcony, String rooftopGarden, String airCondition,
                            String conferenceHall, String jacuzzi, String centralAntenna, String remoteControlledDoor) {
        this.parking = parking;
        this.lobby = lobby;
        this.elevator = elevator;
        this.pool = pool;
        this.sauna = sauna;
        this.gym = gym;
        this.buildingGuard = buildingGuard;
        this.balcony = balcony;
        this.rooftopGarden = rooftopGarden;
        this.airCondition = airCondition;
        this.conferenceHall = conferenceHall;
        this.jacuzzi = jacuzzi;
        this.centralAntenna = centralAntenna;
        this.remoteControlledDoor = remoteControlledDoor;
    }

    public boolean convertStrintToBool(String variable) {
        return "1".equals(variable);
    }
}
