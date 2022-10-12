package hooks;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DataSettingsUtils;

public class Hooks {
    @Before
    public void setup() {

        AqualityServices.getBrowser().maximize();
        AqualityServices.getBrowser().goTo(DataSettingsUtils.getElement("url"));
        AqualityServices.getBrowser().waitForPageToLoad();
    }

    @After
    public void tearDown() {
        AqualityServices.getBrowser().quit();
    }
}
