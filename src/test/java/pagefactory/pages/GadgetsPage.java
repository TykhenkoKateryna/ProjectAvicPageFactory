package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GadgetsPage extends BasePage {

        @FindBy(xpath = "//div[contains(@class,'brand')]/a[contains(text(), 'Смарт-часы')]")
        private WebElement SmartWatch;

        public GadgetsPage (WebDriver driver) {
            super(driver);
        }

        public void clickOnSmartWatchButton() {
            SmartWatch.click();
        }

    }
