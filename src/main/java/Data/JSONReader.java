package Data;




import io.github.bonigarcia.wdm.online.Parser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    public String username,password;
    public void JSONReader() throws IOException, ParseException {
        String filepath = System.getProperty("user.dir")+"/Files/logindata.json";
        File file = new File(filepath);
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray)jsonParser.parse(new FileReader(file));
        for(Object jsonObj : jsonArray){
            JSONObject user = (JSONObject) jsonObj;
            username = (String) user.get("username");
            System.out.println(username);
            password = (String) user.get("password");
            System.out.println(password);

        }


    }


}
