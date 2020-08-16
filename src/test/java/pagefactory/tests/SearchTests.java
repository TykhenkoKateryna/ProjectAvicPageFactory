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
    private String SEARCH_GADGET_KEYWORD = "Xiaomi";

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
        getHomePage().clickOnProductCatalogButton();
        getHomePage().clickOnGadgetButton();
        getGadgetsPage().clickOnSmartWatchButton();
        getBasePage().waitForPageLoadComplete(30);
        getSmartWatchPage().clickOnFilterButton();
        getBasePage().waitForPageLoadComplete(30);
        getBasePage().waitVisibilityOfAddToCartPopup(30, getSmartWatchPage().getFilterPopup());
        getSmartWatchPage().clickOnOpenFilterButton();
        getBasePage().waitForPageLoadComplete(30);
        for (WebElement webElement : getSearchResultsPage().getSearchResultsList()) {
            assertTrue(webElement.getText().contains(SEARCH_GADGET_KEYWORD));
        }
    }
}
