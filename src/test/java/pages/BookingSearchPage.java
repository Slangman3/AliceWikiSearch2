package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookingSearchPage extends BasePage {
    @FindBy(xpath = "//span[contains(@class, 'sr-hotel__name')]")
    private List <WebElement> resultsList;

    public BookingSearchPage(WebDriver driver) {
        super(driver);
    }

}
