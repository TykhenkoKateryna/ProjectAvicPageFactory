package pagefactory.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;

public class AddToCartTests extends BaseTest {

    private String EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART = "1";
    private String EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART_AFTER_DELETE = "0";
    private String EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART_AFTER_ADDING = "2";

    @Test(priority = 1)
    public void checkAddToCart() {
        getHomePage().clickOnProductCatalogButton();
        getHomePage().clickOnAppleStoreButton();
        getAppleStorePage().clickOnIphoneButton();
        getBasePage().waitForPageLoadComplete(30);
        getIphonePage().clickOnAddToCartButton();
        getBasePage().waitVisibilityOfAddToCartPopup(30, getIphonePage().getAddToCartPopup());
        getIphonePage().clickOnContinueShoppingButton();
        assertEquals(getHomePage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART);
    }
    @Test(priority = 2)
    public void checkDeleteFromCart() {
        getHomePage().clickOnProductCatalogButton();
        getHomePage().clickOnAppleStoreButton();
        getAppleStorePage().clickOnIphoneButton();
        getBasePage().waitForPageLoadComplete(30);
        getIphonePage().clickOnAddRedToCartButton();
        getBasePage().waitVisibilityOfAddToCartPopup(30, getIphonePage().getAddToCartPopup());
        getIphonePage().clickOnContinueShoppingButton();
        assertEquals(getHomePage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART);
        getHomePage().clickOnCartButton();
        getBasePage().waitVisibilityOfAddToCartPopup(30, getIphonePage().getAddToCartPopup());
        getHomePage().clickOnRemoveProductButton();
        getBasePage().waitForPageLoadComplete(30);
        getIphonePage().clickOnContinueShoppingButton();
        getHomePage().clickOnGoToHomeButton();
        assertEquals(getHomePage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART_AFTER_DELETE);
    }
    @Test(priority = 3)
    public void checkChangingNumberOfItemsInCart() {
        getHomePage().clickOnProductCatalogButton();
        getHomePage().clickOnAppleStoreButton();
        getAppleStorePage().clickOnIphoneButton();
        getBasePage().waitForPageLoadComplete(30);
        getIphonePage().clickOnAddRedToCartButton();
        getBasePage().waitVisibilityOfAddToCartPopup(30, getIphonePage().getAddToCartPopup());
        getIphonePage().clickOnContinueShoppingButton();
        assertEquals(getHomePage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART);
        getHomePage().clickOnCartButton();
        getBasePage().waitVisibilityOfAddToCartPopup(30, getIphonePage().getAddToCartPopup());
        getHomePage().clickOnAddOneMoreProductButton();
        getBasePage().waitForPageLoadComplete(30);
        getIphonePage().clickOnContinueShoppingButton();
        getHomePage().clickOnGoToHomeButton();
        assertEquals(getHomePage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART_AFTER_ADDING);
        getHomePage().clickOnCartButton();
        getBasePage().waitVisibilityOfAddToCartPopup(30, getIphonePage().getAddToCartPopup());
        getHomePage().clickOnDeductProductButton();
        getBasePage().waitForPageLoadComplete(30);
        getIphonePage().clickOnContinueShoppingButton();
        getHomePage().clickOnGoToHomeButton();
        assertEquals(getHomePage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART);
    }
}
