package steps;

import cucumber.api.java.en.Given;
import io.cucumber.datatable.DataTable;
import model.SearchItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import pages.WikiMainPage;
import pages.WikiSearchPage;
import utils.CapabilitiesGenerator;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsIterableContaining.hasItem;

public class SearchSteps{
    private static final String WIKI_URL = "http://en.wikipedia.org";
    private WikiSearchPage searchPage;
    private WebDriver driver;
    private WikiMainPage wikiMainPage;
    private SearchItem searchItem;
    
    @cucumber.api.java.en.Given("Keyword for search is {string}")
    public void searchKeywordIsString(String keyword) {
        searchItem = new SearchItem(keyword);
    }

    @cucumber.api.java.en.When("User does search")
    public void search() {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.get(WIKI_URL);
        wikiMainPage = new WikiMainPage(driver);
        wikiMainPage.searchByKeyword(searchItem.getSearchString());
        searchPage = new WikiSearchPage(driver);
    }

    @cucumber.api.java.en.Then("Wiki page {string} is on the first page")
    public void assertSearchResult(String result) {
        assertThat(String.format("There are no results for search string '%s' on first search page", result),
                searchPage.getResultLinks(), 
                hasItem(result));
        driver.quit();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
    }
    
    @Given("^I open Facebook URL and create new accounts with below data$")
    public void i_open_Facebook_URL_and_create_new_accounts_with_below_data(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).get("First Name"));
            System.out.println(list.get(i).get("Last Name"));
        }
    }
}

