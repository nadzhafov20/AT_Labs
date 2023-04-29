package lab_5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class JsonParser {
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
        ObjectMapper objectMapper = new ObjectMapper();
        String stringJson=objectMapper.writeValueAsString(user);
        System.out.println(stringJson);

        //part3:
        User inputJsonUser=objectMapper.readValue(new File("input.json"), User.class);
        System.out.println("inputJsonUser" + inputJsonUser);

        //part4:
        inputJsonUser.getFavouriteNumber().add("33");
        objectMapper.writeValue(new File("output.json"),inputJsonUser);
        System.out.println("UpdateInputJsonUser" + inputJsonUser);


    }
}
