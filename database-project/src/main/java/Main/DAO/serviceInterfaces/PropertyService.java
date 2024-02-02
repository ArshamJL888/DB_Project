package Main.DAO.serviceInterfaces;

import Main.Utils.Filter;
import Main.Utils.PropertyCombiner;
import Main.classes.Property;
import Main.classes.PropertyForMortgage;
import Main.classes.PropertyForRent;
import Main.classes.PropertyForSale;

import java.util.List;

public interface PropertyService {

    public List<Property> getAllProperty();

    public List<PropertyForSale> getPropertyForSale();

    public List<PropertyForMortgage> getPropertyForMortgage();

    public List<PropertyForRent> getPropertyForRent();

    public Property getPropertyByID(Long id);

    public void addProperty(Property property);

    public void deleteProperty(Property property);

    void deleteProperty(Long id);

    public void updateProperty(Property property);

    public List<Property> findByFiler(Filter filter);

    List<Property> getAll();
}
