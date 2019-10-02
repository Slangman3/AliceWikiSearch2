package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookingMainPage;
import pages.BookingSearchPage;
import utils.AllureUtils;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class BookingSearchSteps {
    private BookingSearchPage searchPage;
    private WebDriver driver;
    private String searchItem;
    private BookingMainPage bookingMainPage;
    private static final String Booking_URL = "https://www.booking.com/index.ru.html";

    @cucumber.api.java.en.Given("Input keyword for searching {string}")
    public void searchKeywordIsString(String keyword) {
        searchItem = keyword;
    }

    @cucumber.api.java.en.When("User does search on Booking")
    @Step("Пользователь ищет отель {searchItem} на сайте booking.com")
    public void search() {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.get(Booking_URL);
        AllureUtils.takeScreenshot(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        bookingMainPage = new BookingMainPage(driver);
        bookingMainPage.searchByKeyword(searchItem);
        searchPage = new BookingSearchPage(driver);
        AllureUtils.takeScreenshot(driver);
    }

    @cucumber.api.java.en.Then("Booking shows {string}")
    @Step("Проверка на наличие данного отеля в списке")
    public void bookingShows(String hotelsResult) {
        searchPage.resultPageShouldContainHotel(hotelsResult);
        AllureUtils.takeScreenshot(driver);
    }

    @cucumber.api.java.en.And("rating should be {string}")
    @Step("Проверка на соответствие рейтинга отеля, равное: {ratingResult}")
    public void ratingShouldBe(String ratingResult) {
        String hotelName = searchItem;
        searchPage.hotelShouldBeRated(hotelName, ratingResult);
        driver.quit();
        AllureUtils.takeScreenshot(driver);
    }
}
