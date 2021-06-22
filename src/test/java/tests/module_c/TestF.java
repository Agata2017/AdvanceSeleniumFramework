package tests.module_c;

import core.TestBase;
import org.testng.annotations.Test;

public class TestF extends TestBase {

    @Test(groups = {"web"})
    public void TC001(){
        System.out.println("Test F -- TC001");
    }

    @Test
    public void TC002(){
        System.out.println("Test F -- TC002");
    }

}
