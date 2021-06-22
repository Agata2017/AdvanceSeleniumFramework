package tests.module_b;

import core.TestBase;
import org.testng.annotations.Test;

public class TestD extends TestBase {

    @Test(groups = {"web"})
    public void TC001(){
        System.out.println("Test D -- TC001");
        driver().get("https://amazon.co.uk");
    }

    @Test(groups = {"mobile"})
    public void TC002(){
        System.out.println("Test D -- TC002");
        driver().get("https://amazon.co.uk");
    }
}
