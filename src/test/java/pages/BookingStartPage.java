package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingStartPage extends BasePage {
    @FindBy(xpath = "//input[@type='search']")
    private WebElement inputHotelName;
    @FindBy(xpath = "//button[@data-sb-id='main']")
    private WebElement searchBtn;

    public BookingStartPage(WebDriver driver) {
        super(driver);
    }

}
