package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {

    private final IButton MAGNIFIER_BUTTON = AqualityServices.getElementFactory().getButton(By.xpath("//label[@for ='search-panel']/following::div[1]"), "Magnifier button");
    private final ITextBox SEARCH_PANEL_INPUT = AqualityServices.getElementFactory().getTextBox(By.id("search-panel"), "Search panel input");

    public MainPage() {
        super(By.xpath("//div[contains(@class, 'search-panelstyles__SubTitle') and contains(., 'Science-backed')]"), "Main page");
    }

    public void typeWordAndClick(String word) {
        SEARCH_PANEL_INPUT.clearAndType(word);
        MAGNIFIER_BUTTON.clickAndWait();
    }
}
