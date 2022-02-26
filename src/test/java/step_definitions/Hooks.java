package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Driver;

public class Hooks {

    @Before
    public void setup(){
       System.out.println("Hooks setup");
    }

    @After
    public void teardown(){
        Driver.closeDriver();
        System.out.println("Hooks teardown");
    }
}

