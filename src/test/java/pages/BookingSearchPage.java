package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BookingSearchPage extends BasePage {

    @FindBy(xpath = "//span[contains(@class, 'sr-hotel__name')]")
    private List<WebElement> resultsList;

    public BookingSearchPage(WebDriver driver) {
        super(driver);
    }

    public void resultPageShouldContainHotel(String keyword) {
        boolean isFound = false;
        for (WebElement element : resultsList) {
            String hotelName = element.getText();
            if (hotelName.equals(keyword)) {
                isFound = true;
                break;
            }
        }
        assertTrue(isFound);
    }

    public void hotelShouldBeRated(String hotelName, String pointsOfRate) {
        String xpath = String.format("//*[' %s']/../../..//*[@class = 'bui-review-score__badge']", hotelName);
        assertEquals(pointsOfRate, driver.findElement(By.xpath(xpath)).getText());
    }
}
