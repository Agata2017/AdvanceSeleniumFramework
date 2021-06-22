package tests.module_b;

import core.TestBase;
import org.testng.annotations.Test;

public class TestC extends TestBase {

    @Test(groups = {"web"})
    public void TC001(){
        System.out.println("Test C -- TC001");
        driver().get("https://myntra.com");
    }

    @Test
    public void TC002(){
        System.out.println("Test C -- TC002");
        driver().get("https://wizdomqa.com");
    }
}
