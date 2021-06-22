package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private WebDriver driver;
    private RemoteWebDriver remoteWebDriver;

    public WebDriver getDriver() {
        try{
            String browser = TestConfig.getBrowser();
            if(browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
            }else if(browser.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver","C:\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getProperty("implicitWait")), TimeUnit.SECONDS);
            driver.manage().window().getSize();

            driver.manage().window().maximize();
            //driver.manage().window().setSize( new Dimension(1600,900));
        }catch (Exception e){
            // Setup Log
            e.printStackTrace();
        }
        return driver;
    }

    public WebDriver getRemoteWebDriverDocker(String hub_ip){
        try{
            String browser = TestConfig.getBrowser();
            DesiredCapabilities desiredCapabilities = null;
            URL url = new URL("http://"+hub_ip+":4444/wd/hub");
            if(browser.equalsIgnoreCase("chrome")){
                desiredCapabilities = DesiredCapabilities.chrome();
            }else if(browser.equalsIgnoreCase("firefox")){
                desiredCapabilities = DesiredCapabilities.firefox();
            }
            remoteWebDriver = new RemoteWebDriver(url,desiredCapabilities);
            remoteWebDriver.manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
            remoteWebDriver.manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getProperty("implicitWait")), TimeUnit.SECONDS);
            // TO DO -- Set Window Size
        }catch (Exception e){
            // Setup Log
            e.printStackTrace();
        }
        return remoteWebDriver;
    }
    
    public WebDriver getRemoteWebDriver(){
        try{
            String browser = TestConfig.getBrowser();
            DesiredCapabilities desiredCapabilities = null;
            URL url = new URL("http://127.0.0.1:4444/wd/hub");
            if(browser.equalsIgnoreCase("chrome")){
                desiredCapabilities = DesiredCapabilities.chrome();
            }else if(browser.equalsIgnoreCase("firefox")){
                desiredCapabilities = DesiredCapabilities.firefox();
            }
            remoteWebDriver = new RemoteWebDriver(url,desiredCapabilities);
            remoteWebDriver.manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
            remoteWebDriver.manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getProperty("implicitWait")), TimeUnit.SECONDS);
            // TO DO -- Set Window Size
        }catch (Exception e){
            // Setup Log
            e.printStackTrace();
        }
        return remoteWebDriver;
    }
}
