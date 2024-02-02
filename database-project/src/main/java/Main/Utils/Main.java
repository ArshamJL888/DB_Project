package Main.Utils;

import Main.classes.PropertyCondition;
import Main.classes.PropertyFacility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Filter filter=new Filter();
        String json = ow.writeValueAsString
                (new Filter(new PropertyFacility(),new PropertyCondition(),"city 1","zone 1",54,150,
                        "resedential",4L,1L,10L,1L,1000L
                        ,1000000L,3000L,3000000L    ,null,null));
        System.out.println(json);
    }
}
