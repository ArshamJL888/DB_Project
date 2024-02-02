package Main.DAO.serviceImplementations;

import Main.DAO.repos.PropertyRepo;
import Main.DAO.serviceInterfaces.PropertyService;
import Main.Utils.Filter;
import Main.classes.Property;
import Main.classes.PropertyForMortgage;
import Main.classes.PropertyForRent;
import Main.classes.PropertyForSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {

    private PropertyRepo repo;

    @Autowired
    public PropertyServiceImpl(PropertyRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Property> getAllProperty() {
        return repo.findAll();
    }

    @Override
    public List<PropertyForSale> getPropertyForSale() {
        return repo.getPropertyForSale();
    }

    @Override
    public List<PropertyForMortgage> getPropertyForMortgage() {
        return repo.getPropertyForMortgage();
    }

    @Override
    public List<PropertyForRent> getPropertyForRent() {
        return repo.getPropertyForRent();
    }

    @Override
    public Property getPropertyByID(Long id) {
        Optional<Property> property = repo.findById(id);
        if (property.isPresent())
            return property.get();
        else throw new RuntimeException();
    }

    @Override
    public void addProperty(Property property) {
        if (repo.findById(property.getPropertyId()).isPresent()) {
            property.setPropertyId(null);
        }
        repo.save(property);
    }

    @Override
    public void deleteProperty(Property property) {
        repo.delete(property);
    }

    @Override
    public void deleteProperty(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void updateProperty(Property property) {
        if (property.getClass().equals(PropertyForMortgage.class)) {
            repo.updatePropertyForMortgage((PropertyForMortgage) property);
        } else if (property.getClass().equals(PropertyForRent.class)) {
            repo.updatePropertyForRent((PropertyForRent) property);
        } else {
            repo.updatePropertyForSale((PropertyForSale) property);
        }
    }

    @Override
    public List<Property> findByFiler(Filter filter) {
        System.out.println(filter);
        List<Property> properties = null;
        if (filter.getPropertyType() == 1) {
            properties = repo.joinOnPropertyConditionForSaleAndFacilities(filter.getCondition(), filter.getFacility()
                    , filter.getMinAge(), filter.getMaxAge(),
                    filter.getNumberOfRoom(), filter.getMinArea(), filter.getMaxArea(), filter.getUsage()
                    , filter.getZone(), filter.getCity(), classType(filter.getPropertyType()),
                    filter.getMinSellCost(), filter.getMaxSellCost());
        } else if (filter.getPropertyType() == 2 || filter.getPropertyType() == 3) {
            properties = repo.joinOnPropertyConditionForRentAndFacilities(filter.getCondition(), filter.getFacility()
                    , filter.getMinAge(), filter.getMaxAge(),
                    filter.getNumberOfRoom(), filter.getMinArea(), filter.getMaxArea(), filter.getUsage()
                    , filter.getZone(), filter.getCity(), filter.getMinPreCostMortgage()
                    , filter.getMaxPreCostMortgage()
                    , filter.getMinMonthlyRent(), filter.getMaxMonthlyRent());
            properties.addAll(repo.joinOnPropertyForMortgageConditionAndFacilities(filter.getCondition(), filter.getFacility()
                    , filter.getMinAge(), filter.getMaxAge(),
                    filter.getNumberOfRoom(), filter.getMinArea(), filter.getMaxArea(), filter.getUsage()
                    , filter.getZone(), filter.getCity()
                    , filter.getMinPreCostMortgage(), filter.getMaxPreCostMortgage()));
        }
        return properties;
    }

    public Class classType(Long type) {
        if (type == 1) {
            return PropertyForSale.class;
        } else if (type == 2) {
            return PropertyForMortgage.class;
        } else if (type == 3) {
            return PropertyForRent.class;
        }
        return Object.class;
    }

    @Override
    public List<Property> getAll() {
        List<Property> properties = repo.showAllProperties();
        return properties;
    }
}
