package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookingMainPage;
import pages.BookingSearchPage;

import java.util.concurrent.TimeUnit;

public class BookingSearchSteps {
    private BookingSearchPage searchPage;
    private WebDriver driver;
    private String searchItem;
    private BookingMainPage bookingMainPage;
    private static final String Booking_URL = "https://www.booking.com/index.ru.html";

    @cucumber.api.java.en.Given("Input keyword for searching {string}")
    public void searchKeywordIsString(String keyword) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        searchItem = keyword;
    }

    @cucumber.api.java.en.When("User does search on Booking")
    public void search() {
        driver = new ChromeDriver();
        driver.get(Booking_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        bookingMainPage = new BookingMainPage(driver);
        bookingMainPage.searchByKeyword(searchItem);
        searchPage = new BookingSearchPage(driver);
    }

    @cucumber.api.java.en.Then("Booking shows {string}")
    public void bookingShows(String hotelsResult) {
        searchPage.resultPageShouldContainHotel(hotelsResult);
    }

    @cucumber.api.java.en.And("rating should be {string}")
    public void ratingShouldBe(String ratingResult) {
        String hotelName = searchItem;
        searchPage.hotelShouldBeRated(hotelName, ratingResult);
        driver.quit();
    }
}
