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
        driver.findElement(xpath("//span[@class='sidebar-item']")).click();
        driver.findElement(xpath("//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'apple-store')]")).click();
        driver.findElement(xpath("//div[@class='brand-box__title']/a[contains(@href,'iphone')]")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(xpath("//a[@class='prod-cart__buy'][contains(@data-ecomm-cart,'Red (MX9U2)')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_cart")));
        driver.findElement(xpath("//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")).click();
        String actualProductsCountInCart =
                driver.findElement(xpath("//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]")).getText();
        assertEquals(actualProductsCountInCart, "1");
        driver.findElement(xpath("//div[contains(@class,'header-bottom')]//i[@class='icon icon-cart-new']")).click();//open cart
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_cart")));
        driver.findElement(xpath("//div/i[@data-cart-remove]")).click();//remove product
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(xpath("//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")).click();
        driver.findElement(xpath("//div[contains(@class,'bottom__logo')]//img")).click();
        String actualProductsCountInCart2 =
                driver.findElement(xpath("//div[contains(@class,'header-bottom')]/div[contains(@class,'cart_count')]")).getText();
        assertEquals(actualProductsCountInCart2, "0");
    }
    @Test(priority = 3)
    public void checkChangingNumberOfItemsInCart() {
        driver.findElement(xpath("//span[@class='sidebar-item']")).click();
        driver.findElement(xpath("//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'apple-store')]")).click();
        driver.findElement(xpath("//div[@class='brand-box__title']/a[contains(@href,'iphone')]")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(xpath("//a[@class='prod-cart__buy'][contains(@data-ecomm-cart,'Red (MX9U2)')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_cart")));
        driver.findElement(xpath("//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")).click();
        String actualProductsCountInCart =
                driver.findElement(xpath("//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]")).getText();
        assertEquals(actualProductsCountInCart, "1");
        driver.findElement(xpath("//div[contains(@class,'header-bottom')]//i[@class='icon icon-cart-new']")).click();//open cart
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_cart")));
        driver.findElement(xpath("//span[contains(text(),'+')]")).click();//+1 product
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(xpath("//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")).click();
        driver.findElement(xpath("//div[contains(@class,'bottom__logo')]//img")).click();
        String actualProductsCountInCart2 =
                driver.findElement(xpath("//div[contains(@class,'header-bottom')]/div[contains(@class,'cart_count')]")).getText();
        assertEquals(actualProductsCountInCart2, "2");
        driver.findElement(xpath("//div[contains(@class,'header-bottom')]//i[@class='icon icon-cart-new']")).click();//open cart
        WebDriverWait wait3 = new WebDriverWait(driver, 30);
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_cart")));
        driver.findElement(xpath("//div[contains(@class,'js')]//span[contains(text(),'-')]")).click();//-1 product
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(xpath("//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")).click();
        driver.findElement(xpath("//div[contains(@class,'bottom__logo')]//img")).click();
        String actualProductsCountInCart3 =
                driver.findElement(xpath("//div[contains(@class,'header-bottom')]/div[contains(@class,'cart_count')]")).getText();
        assertEquals(actualProductsCountInCart3, "1");


    }
}
