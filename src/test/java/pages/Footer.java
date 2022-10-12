package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class Footer extends Form {

    private static final int BOLD_VALUE = 700;
    private static final String FONT_WEIGHT = "font-weight";
    private static final String COLUMN_NAMES_LOCATOR = "//div[contains(@class, 'sc-jJoQJp')]//*[contains(@class, 'sc-hiCibw')]";
    private static final String NETWORK_BUTTON_LOCATOR_PATTERN = "//a[@title = '%s']";

    public Footer() {
        super(By.xpath("//footer[contains(@class, 'sc-kfPuZi')]"), "Footer");
    }

    public boolean isAllColumnsInFontBold() {
        return getColumnNames().stream().allMatch(elem -> Integer.parseInt(elem.getCssValue(FONT_WEIGHT)) == BOLD_VALUE);
    }

    public void clickNetworkButton(String network) {
        getNetworkButton(network).clickAndWait();
    }

    private List<IElement> getColumnNames() {
        return AqualityServices.getElementFactory().findElements(By.xpath(COLUMN_NAMES_LOCATOR), ElementType.TEXTBOX);
    }

    private IButton getNetworkButton(String network) {
        return AqualityServices.getElementFactory().getButton(By.xpath(String.format(NETWORK_BUTTON_LOCATOR_PATTERN, network)), network);
    }
}
