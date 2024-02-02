package Main.DAO.serviceInterfaces;

import Main.classes.PropertyFacility;

import java.util.List;

public interface PropertyFacilityService {

    public void addPropertyFacility(PropertyFacility propertyFacility);

    public void deletePropertyFacility(PropertyFacility propertyFacility);

    void deletePropertyFacility(Long id);

    public void updatePropertyFacility(PropertyFacility propertyFacility);

    public List<PropertyFacility> getAllPropertyFacility();

    public PropertyFacility getAllPropertyFacilityById(Long id);

}
