package tests.module_a;

import core.TestBase;
import org.testng.annotations.Test;

public class TestB extends TestBase {

    @Test(groups = {"web"})
    public void TC001(){
        System.out.println("Test B -- TC001");
        driver().get("https://amazon.in");
    }

    @Test
    public void TC002(){
        System.out.println("Test B -- TC002");
        driver().get("https://amazon.com");
    }


}
