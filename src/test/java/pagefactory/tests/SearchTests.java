package pagefactory.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest {

    private String SEARCH_KEYWORD = "iPhone 11";
    private String EXPECTED_SEARCH_QUERY = "query=iPhone";

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_SEARCH_QUERY));
    }

    @Test(priority = 2)
    public void checkElementsAmountOnSearchPage() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getBasePage().implicitWait(30);
        assertEquals(getSearchResultsPage().getSearchResultsCount(), 12);
    }

    @Test(priority = 3)
    public void checkThatSearchResultsContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        for (WebElement webElement : getSearchResultsPage().getSearchResultsList()) {
            assertTrue(webElement.getText().contains(SEARCH_KEYWORD));
        }
    }
    @Test(priority = 4)
    public void checkThatFilterResultsContainsFilterWord() {
        driver.findElement(xpath("//span[@class='sidebar-item']")).click();
        driver.findElement(xpath("//li[contains(@class,'sidebar')]/a[contains(@href, 'gadzhetyi1')]")).click();
        driver.findElement(xpath("//div[contains(@class,'brand')]/a[contains(text(), 'Смарт-часы')]")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(xpath("//label[contains(@for,'fltr-proizvoditel-xiaomi')]")).click();
        WebDriverWait wait5 = new WebDriverWait(driver, 30);
        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'open-filter')]//a[contains(@class,'accept')]")));
        driver.findElement(xpath("//div[contains(@class,'open-filter')]//span[@class='filter-tooltip-inner']")).click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> elementList = driver.findElements(xpath("//div[@class='prod-cart__descr']"));
        for (WebElement webElement : elementList) {
            assertTrue(webElement.getText().contains("Xiaomi"));
        }
}
