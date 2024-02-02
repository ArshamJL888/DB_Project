package Main.DAO.repos;

import Main.classes.RealStateAgency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgencyRepo extends JpaRepository<RealStateAgency,Long> {
    @Query("select agency  from RealStateAgency agency WHERE agency.aName=:Aname")
    RealStateAgency findRealStateAgencyByAName(@Param(value = "Aname") String AName);

    @Query("select agency  from RealStateAgency agency WHERE agency.mPhone=:mphone")
    RealStateAgency findRealStateAgencyByMPhone(@Param(value = "mphone") String MPhone);

    @Modifying
    @Query("update RealStateAgency a set a.aPhone= ?1 , a.empCount= ?2 where a.id= ?3")
    void updatePhoneNumberAndNumberOfWorkers( String phoneNumber,Integer numberOfWorkers,Long id);
}
