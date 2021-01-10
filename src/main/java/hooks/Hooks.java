package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import utils.Wait;

import java.net.MalformedURLException;

import static utils.Driver.Android_LaunchApp;
import static utils.Driver.closeApp;

public class Hooks {

    @Before
    public void Before() throws MalformedURLException {
        Android_LaunchApp();
    }
    @BeforeStep
    public void WaitStep(){
        Wait.sec(2);
    }
    @After
    public void After() {
      closeApp();
    }
}