package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class SmartWatchPage extends BasePage {

        @FindBy(xpath = "//label[contains(@for,'fltr-proizvoditel-xiaomi')]")
        private WebElement FilterButton;

        @FindBy(xpath = "//div[contains(@class,'open-filter')]//a[contains(@class,'accept')]")
        private WebElement FilterPopup;

        @FindBy(xpath = "//div[contains(@class,'open-filter')]//span[@class='filter-tooltip-inner']")
        private WebElement OpenFilterButton;

        public SmartWatchPage(WebDriver driver) {
            super(driver);
        }

        public void clickOnFilterButton() {
            FilterButton.click();
        }

        public void clickOnOpenFilterButton() {
            OpenFilterButton.click();
        }

        public WebElement getFilterPopup() {
            return FilterPopup;
        }

    }


