package net.meetsky.step_definitions;

import io.cucumber.java.After;
import net.meetsky.utilities.Driver;

public class Hooks {

    @After
    public void teardownScenario() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }

}
