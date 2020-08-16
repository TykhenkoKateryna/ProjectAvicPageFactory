package pagefactory.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@class='sidebar-item']")
    private WebElement productCatalogButton;

    @FindBy(xpath = "//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'apple-store')]")
    private WebElement appleStoreButton;

    @FindBy(xpath = "//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]")
    private WebElement amountOfProductsInCart;

    @FindBy(xpath = "//li[contains(@class,'sidebar')]/a[contains(@href, 'gadzhetyi1')]")
    private WebElement GadgetButton;

    @FindBy(xpath = "//div/i[@data-cart-remove]")
    private WebElement removeProductButton;

    @FindBy(xpath = "//span[contains(text(),'+')]")
    private WebElement AddOneMoreProductButton;

    @FindBy(xpath = "//div[contains(@class,'js')]//span[contains(text(),'-')]")
    private WebElement DeductProductButton;

    @FindBy(xpath = "//div[contains(@class,'header-bottom')]//i[@class='icon icon-cart-new']")
    private WebElement CartButton;

    @FindBy(xpath ="//div[contains(@class,'bottom__logo')]//img")
    private WebElement GoToHomeButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnProductCatalogButton() {
        productCatalogButton.click();
    }

    public void clickOnAppleStoreButton() {
        appleStoreButton.click();
    }

    public String getTextOfAmountProductsInCart() {
        return amountOfProductsInCart.getText();
    }

    public void clickOnCartButton() {
        CartButton.click();
    }

    public void clickOnRemoveProductButton() {
        removeProductButton.click();
    }

    public void clickOnAddOneMoreProductButton() {AddOneMoreProductButton.click(); }

    public void clickOnDeductProductButton() {DeductProductButton.click(); }

    public void clickOnGadgetButton() {
        GadgetButton.click();
    }

    public void clickOnGoToHomeButton() {
        GoToHomeButton.click();
    }

}
