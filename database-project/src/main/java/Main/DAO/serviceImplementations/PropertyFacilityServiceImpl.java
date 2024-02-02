package Main.DAO.serviceImplementations;

import Main.DAO.repos.PropertyFacilityRepo;
import Main.DAO.serviceInterfaces.PropertyFacilityService;
import Main.classes.PropertyFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PropertyFacilityServiceImpl implements PropertyFacilityService {

    private PropertyFacilityRepo repo;

    @Autowired
    public PropertyFacilityServiceImpl(PropertyFacilityRepo repo) {
        this.repo = repo;
    }

    @Override
    public void addPropertyFacility(PropertyFacility propertyFacility) {
        repo.save(propertyFacility);
    }

    @Override
    public void deletePropertyFacility(PropertyFacility propertyFacility) {
        repo.delete(propertyFacility);
    }

    @Override
    public void deletePropertyFacility(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void updatePropertyFacility(PropertyFacility propertyFacility) {
        repo.updatePropertyFacilityFields(propertyFacility);
    }

    @Override
    public List<PropertyFacility> getAllPropertyFacility() {
        return repo.findAll();
    }

    @Override
    public PropertyFacility getAllPropertyFacilityById(Long id) {
        Optional<PropertyFacility> propertyFacility = repo.findById(id);
        if (propertyFacility.isPresent()) {
            return propertyFacility.get();
        } else {
            throw new RuntimeException();
        }
    }
}
