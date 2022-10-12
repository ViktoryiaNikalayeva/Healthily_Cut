package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends Form {
    private final List<ILabel> SEARCH_RESULTS_LABELS = AqualityServices.getElementFactory().findElements(By.xpath
            ("//a[contains(@class, 'search-result-itemstyles')]"), ElementType.LABEL);

    public SearchPage() {
        super(By.xpath("//div[contains(@class, 'search-panelstyles__SubTitle') and contains(., 'Get the facts')]"), "Search page");
    }

    public boolean isAllResultsWithKeyWord(String word) {
        return getResultList().stream().allMatch(x -> StringUtils.containsIgnoreCase(x, word));
    }

    private ArrayList<String> getResultList() {
        return SEARCH_RESULTS_LABELS.stream().map(IElement::getText).collect(Collectors.toCollection(ArrayList::new));
    }
}
