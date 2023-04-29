package lab_5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class XMLParser {
    public static void main(String[] args) throws IOException {
        // a) Make some complex models using your variant.
        //b) Make it serializable.
        //c) Read json from “input.json”
        //d) and deserialize it to POJO.
        //e) Then change a few fields and save it to “output.json”.
        //f) Do the same for xml.


        //part1: ствоерння моделі
        User user = new User();
        user.setName("Michael");
        user.setAge(28);
        user.setFavouriteNumber(Arrays.asList("7", "13", "19"));
        System.out.println(user);

        //part2:
        XmlMapper xmlMapper = new XmlMapper();
        String stringXML=xmlMapper.writeValueAsString(user);
        System.out.println(stringXML);

        //part3:
        User inputXMLUser=xmlMapper.readValue(new File("input.xml"),User.class);
        System.out.println("inputXMLUser" + inputXMLUser);

        //part4:
        inputXMLUser.getFavouriteNumber().add("33");
        xmlMapper.writeValue(new File("output.xml"),inputXMLUser);
        System.out.println("UpdateInputXMLUser" + inputXMLUser);


    }
}
