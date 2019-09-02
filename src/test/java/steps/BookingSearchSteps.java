package steps;

import model.SearchItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookingMainPage;
import pages.BookingSearchPage;

public class BookingSearchSteps {
    private BookingSearchPage searchPage;
    private WebDriver driver;
    private String searchString;
    private SearchItem searchItem;
    private BookingMainPage bookingMainPage;
    private static final String Booking_URL = "https://www.booking.com/index.ru.html";

    @cucumber.api.java.en.Given("Input keyword for searching {string}")
    public void searchKeywordIsString(String keyword) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        searchItem = new SearchItem(keyword);
    }

    @cucumber.api.java.en.When("User does search Hilton on Booking")
    public void search() {
        driver = new ChromeDriver();
        driver.get(Booking_URL);
        bookingMainPage = new BookingMainPage(driver);
        bookingMainPage.searchByKeyword(searchItem.getSearchString());
        searchPage = new BookingSearchPage(driver);
    }
    

}
