package Main.controllers;

import Main.DAO.serviceInterfaces.PictureService;
import Main.DAO.serviceInterfaces.PropertyConditionService;
import Main.DAO.serviceInterfaces.PropertyFacilityService;
import Main.DAO.serviceInterfaces.PropertyService;
import Main.Utils.Filter;
import Main.Utils.PropertyCombiner;
import Main.classes.Picture;
import Main.classes.Property;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private PropertyFacilityService propertyFacilityService;

    @Autowired
    private PropertyConditionService propertyConditionService;

    @Autowired
    private PictureService pictureService;

    List<PropertyCombiner>propertyCombiners;

    @PostConstruct
    public void PropertyCombiners() {
        this.propertyCombiners = new ArrayList<>();
    }

    @PostMapping("/show")
    public List<PropertyCombiner> getLists(@RequestBody Filter filter) {
        propertyCombiners.clear();
        List<Property> properties = propertyService.findByFiler(filter);
        System.out.println(filter);
        for (Property property:properties) {
            propertyCombiners.add(new PropertyCombiner
                    (property, propertyFacilityService.getAllPropertyFacilityById(property.getPropertyId())
                            ,propertyConditionService.getAllPropertyConditionById(property.getPropertyId()),
                            pictureService.getPicturesById(property.getPropertyId())));
        }
        System.out.println(propertyCombiners);
        return propertyCombiners;
    }

    @GetMapping("/show/all")
    public List<PropertyCombiner> getAllLists() {
        propertyCombiners.clear();
        List<Property> properties = propertyService.getAll();
//        System.out.println(properties);
        for (Property property:properties) {
            propertyCombiners.add(new PropertyCombiner
                    (property, propertyFacilityService.getAllPropertyFacilityById(property.getPropertyId())
                            ,propertyConditionService.getAllPropertyConditionById(property.getPropertyId()),
                            pictureService.getPicturesById(property.getPropertyId())));
        }
        return propertyCombiners;
    }

    @GetMapping("/show/{id}")
    public PropertyCombiner showProperty(@PathVariable String id){
        PropertyCombiner propertyCombiner=new PropertyCombiner
                (propertyService.getPropertyByID(Long.valueOf(id)), propertyFacilityService.getAllPropertyFacilityById(Long.valueOf(id))
                        ,propertyConditionService.getAllPropertyConditionById(Long.valueOf(id)),
                        pictureService.getPicturesById(Long.valueOf(id)));
        return propertyCombiner;
    }

    @PutMapping("/update")
    public PropertyCombiner updateProperty(@RequestBody PropertyCombiner propertyCombiner){
        propertyService.updateProperty(propertyCombiner.getProperty());
        propertyConditionService.updatePropertyCondition(propertyCombiner.getCondition());
        propertyFacilityService.updatePropertyFacility(propertyCombiner.getFacility());
        //TODO: setup picture support
        return propertyCombiner;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProperty(@PathVariable Long id){
        propertyFacilityService.deletePropertyFacility(id);
        propertyConditionService.deletePropertyCondition(id);
        pictureService.removePictureByPictureKeyPropertyID(id);
        propertyService.deleteProperty(id);

        return "deleted";
    }

    @PostMapping("/add")
    public PropertyCombiner addProperty(@RequestBody PropertyCombiner propertyCombiner){
        System.out.println(propertyCombiner);
        propertyService.addProperty(propertyCombiner.getProperty());
        //setting the generated property key
        propertyCombiner.getFacility().setPropertyId(propertyCombiner.getProperty().getPropertyId());
        propertyCombiner.getCondition().setPropertyId(propertyCombiner.getProperty().getPropertyId());

        propertyFacilityService.addPropertyFacility(propertyCombiner.getFacility());
        propertyConditionService.addPropertyCondition(propertyCombiner.getCondition());
        try {
            for (Picture p : propertyCombiner.getPicture()) {
                pictureService.addPicture(p);
            }
        }catch (Exception ignored){}
        return propertyCombiner;
    }
}
