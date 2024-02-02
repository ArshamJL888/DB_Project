package Main.DAO.serviceInterfaces;

import Main.classes.RealStateAgency;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgencyService {

    public List<RealStateAgency> getAgencies();

    public RealStateAgency findById(Long id);

    public RealStateAgency findByName(String name);

    public void addAgency(RealStateAgency agency);

    public void deleteAgency(RealStateAgency agency);

    public void updateAgency(RealStateAgency agency);

    RealStateAgency findRealStateAgencyByMPhone(String MPhone);

}
