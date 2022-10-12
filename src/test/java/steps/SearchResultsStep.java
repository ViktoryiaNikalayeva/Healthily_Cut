package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MainPage;
import pages.SearchPage;

public class SearchResultsStep {


    @Given("MainPage is opened")
    public void isMainPageOpened() {
        Assert.assertTrue(new MainPage().state().waitForDisplayed(), "Main page is not opened");
    }

    @When("^I type '(.*)' in the search bar and click magnifier")
    public void typeWordAndClick(String word) {
        new MainPage().typeWordAndClick(word);
    }

    @Then("^All results contain '(.*)'")
    public void checkAllResultsContainKeyWord(String word) {
        Assert.assertTrue(new SearchPage().state().waitForDisplayed(), "Search page is not opened");
        Assert.assertTrue(new SearchPage().isAllResultsWithKeyWord(word), "Not all results contain key word");
    }
}
