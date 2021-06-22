package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestBase {

    private WebDriver driver;
    private DriverFactory driverFactory;

    @BeforeSuite(alwaysRun=true)
    public void initSuite(){
        TestConfig.loadProperties();
    }

    @BeforeClass(alwaysRun=true)
    public void initDriver()  {
        driverFactory = new DriverFactory();
        if(System.getenv("runtype").equals("local")){
            driver = driverFactory.getDriver();
        }else if(System.getenv("runtype").equals("remote")){
            driver = driverFactory.getRemoteWebDriver();
        }else if(System.getenv("runtype").equals("docker")){
            driver = driverFactory.getRemoteWebDriverDocker(System.getenv("hub"));
        }
    }

    @AfterClass(alwaysRun=true)
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    public WebDriver driver(){
        return driver;
    }

    @DataProvider
    public Object[][] getData(Method testCase) throws Exception {
        File testDataLocation = new File("src/main/resources/testdata");
        List<HashMap<String,String>> extractedData = null;
        String envName  =  TestConfig.getProperty("env");
        JSONDataProvider testData = new JSONDataProvider(testDataLocation+"/data."+envName+".json");
        extractedData = testData.getAllData(testCase.getName());
        return this.createDataProvider(extractedData);
    }

    private Object[][] createDataProvider(Object dataSet){
        int rowNo = ((ArrayList)dataSet).size();
        Object[][] dataArray = new Object[rowNo][2];
        int dim = 0;
        for(int iRow=0;iRow<rowNo;iRow++) {
            dataArray[dim][0] = iRow+1;
            dataArray[dim][1] = ((ArrayList)dataSet).get(iRow);
            dim++;
        }
        return dataArray;
    }

}
