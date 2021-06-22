package core;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class TestConfig {

    private static String browser = System.getenv("browser");
    private static String env = System.getenv("env");
    private static Properties properties;

    public static String getProperty(String prop){
        if(properties.containsKey(prop)){
            return properties.getProperty(prop);
        }
        return null;
    }

    public static String getBrowser(){
        return browser;
    }

    public static String getEnv(){
        return env;
    }

    public static void loadProperties() {
        try {
            URL configPath = TestConfig.class.getClassLoader().getResource("config/config."+env+".properties");
            FileInputStream fileInputStream = new FileInputStream(configPath.getFile());
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (IOException ex) {
            ex.getStackTrace();
        }
    }
}
