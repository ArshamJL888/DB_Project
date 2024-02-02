package Main.DAO.serviceImplementations;

import Main.DAO.repos.AgencyRepo;
import Main.DAO.serviceInterfaces.AgencyService;
import Main.classes.RealStateAgency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AgencyServiceImpl implements AgencyService {

    private AgencyRepo repo;

    @Autowired
    public AgencyServiceImpl(AgencyRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<RealStateAgency> getAgencies() {
        return repo.findAll();
    }

    @Override
    public RealStateAgency findById(Long id) {
        Optional<RealStateAgency>agency=repo.findById(id);
        if (agency.isPresent()) {
            return agency.get();
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public RealStateAgency findByName(String name) {
        return repo.findRealStateAgencyByAName(name);
    }

    @Override
    public void addAgency(RealStateAgency agency) {
        if (repo.findById(agency.getId()).isPresent()){
            agency.setId(null);
        }
        repo.save(agency);
    }

    @Override
    public void deleteAgency(RealStateAgency agency) {
        repo.delete(agency);
    }

    @Override
    public void updateAgency(RealStateAgency agency) {
        repo.updatePhoneNumberAndNumberOfWorkers(agency.getAPhone(),agency.getEmpCount(), agency.getId());
    }

    @Override
    public RealStateAgency findRealStateAgencyByMPhone(String MPhone) {
        return repo.findRealStateAgencyByMPhone(MPhone);
    }
}
