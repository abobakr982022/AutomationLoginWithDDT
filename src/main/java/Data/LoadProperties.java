package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {


    public static Properties loginData;

    static {
        try {
            String dir = System.getProperty("user.dir");
            loginData = LoadProperties(dir+"\\Files\\ProperiesFile.properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //1-Load the properties File
    private static Properties LoadProperties(String path) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        Properties properties = new Properties();
        //2-stream reading file
        FileInputStream fileInputStream = new FileInputStream(path);
        properties.load(fileInputStream);
        return properties;
    }
}
