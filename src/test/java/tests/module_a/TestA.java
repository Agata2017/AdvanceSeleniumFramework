package tests.module_a;

import core.TestBase;
import org.testng.annotations.Test;

public class TestA extends TestBase {

    @Test(groups = {"web"})
    public void TC001(){
        System.out.println("Test A -- TC001");
        driver().get("https://amazon.co.uk");
    }

    @Test
    public void TC002(){
        System.out.println("Test A -- TC002");
        driver().get("https://www.rentalcars.com/");
    }


}
