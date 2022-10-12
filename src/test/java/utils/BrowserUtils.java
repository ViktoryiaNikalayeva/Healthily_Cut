package utils;

import aquality.selenium.browser.AqualityServices;

public class BrowserUtils {

    public static String openPageGetNewPageLinkValueClosePage() {
        AqualityServices.getBrowser().tabs().switchToLastTab();
        return AqualityServices.getBrowser().getCurrentUrl();
    }
}
