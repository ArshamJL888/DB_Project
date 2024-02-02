package Main.classes;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "real_estate_agency")
@Data
public class RealStateAgency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "agency_id")
    private Long id;

    @Column(name = "a_name")
    private String aName;

    @Column(name = "a_phone")
    private String aPhone;

    @Column(name = "a_city")
    private String aCity;

    @Column(name = "emp_count")
    private Integer empCount;

    @Column(name = "m_name")
    private String mName;

    @Column(name = "m_family")
    private String mFamily;

    @Column(name = "m_phone")
    private String mPhone;

    @Column(name = "password")
    private String password;

    public RealStateAgency(String aName, String aCity, String mName, String mFamily, String mPhone, String password) {
        this.aName = aName;
        this.aCity = aCity;
        this.mName = mName;
        this.mFamily = mFamily;
        this.mPhone = mPhone;
        this.password = password;
        aPhone="";
        empCount=0;
        System.out.println(this);
    }

    public RealStateAgency() {

    }
}
