package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BookingSearchPage extends BasePage {

    public BookingSearchPage(WebDriver driver) {
        super(driver);
    }

    public void resultPageShouldContainHotel(String keyword) {
        boolean isFound = false;
        List<WebElement> resultsList = driver.findElements(By.xpath("//span[contains(@class, 'sr-hotel__name')]"));
        System.out.println(String.format("List of results contains %s records",resultsList.size()));
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
