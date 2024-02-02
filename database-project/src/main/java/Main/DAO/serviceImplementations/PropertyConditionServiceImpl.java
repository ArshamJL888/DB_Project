package Main.DAO.serviceImplementations;

import Main.DAO.repos.PropertyConditionRepo;
import Main.DAO.serviceInterfaces.PropertyConditionService;
import Main.classes.PropertyCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//TODO:add missing function bodies
@Service
@Transactional
public class PropertyConditionServiceImpl implements PropertyConditionService {

    private PropertyConditionRepo repo;

    @Autowired
    public PropertyConditionServiceImpl(PropertyConditionRepo repo) {
        this.repo = repo;
    }

    @Override
    public void addPropertyCondition(PropertyCondition propertyCondition) {
        repo.save(propertyCondition);
    }

    @Override
    public void deletePropertyCondition(PropertyCondition propertyCondition) {
        repo.delete(propertyCondition);
    }

    @Override
    public void updatePropertyCondition(PropertyCondition propertyCondition) {
        repo.updatePropertyConditionFields(propertyCondition);
    }

    @Override
    public void deletePropertyCondition(Long id) {
        repo.deleteById(id);
    }


    @Override
    public List<PropertyCondition> getAllPropertyCondition() {
        return repo.findAll();
    }

    @Override
    public PropertyCondition getAllPropertyConditionById(Long id) {
        Optional<PropertyCondition> propertyCondition = repo.findById(id);
        if (propertyCondition.isPresent()) {
            return propertyCondition.get();
        } else {
            throw new RuntimeException();
        }
    }

}
