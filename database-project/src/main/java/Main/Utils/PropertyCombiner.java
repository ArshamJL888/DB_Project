package Main.Utils;

import Main.classes.Picture;
import Main.classes.Property;
import Main.classes.PropertyCondition;
import Main.classes.PropertyFacility;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class PropertyCombiner {
   private Property property;
   private PropertyFacility facility;
   private PropertyCondition condition;

   private List<Picture> picture;

   public PropertyCombiner(Property property, PropertyFacility facility, PropertyCondition condition, List<Picture> picture) {
      this.property = property;
      this.facility = facility;
      this.condition = condition;
      this.picture = picture;
   }


}
