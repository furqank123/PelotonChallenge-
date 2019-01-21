package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddBikeToCart {

    @FindBy(css = "a.sc-gVLVqr:nth-child(1)")
    public static WebElement bike;

    @FindBy(css = ".sc-iYUSvU")
    public static WebElement buyTheBike;

    @FindBy(css = "article.sc-fYiAbW:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(2)")
    public static WebElement shopNow;

    @FindBy(css = ".sc-cMhqgX > button:nth-child(1)")
    public static WebElement addToCart;

    @FindBy(css = ".sc-bGbJRg > p:nth-child(1)")
    public static WebElement myCart;

    public AddBikeToCart tapOnBike() {
        bike.isDisplayed();
        bike.click();
        return this;
    }

    public AddBikeToCart clickOnBuyTheBike() {
        buyTheBike.isDisplayed();
        buyTheBike.click();
        return this;
    }

    public AddBikeToCart clickOnShopNow() {
        shopNow.isDisplayed();
        shopNow.click();
        return this;
    }

    public AddBikeToCart clickOnAddToCart() {
        addToCart.isDisplayed();
        addToCart.click();
        return this;
    }

    public AddBikeToCart verifyCartIsLaunched() {
        myCart.isDisplayed();
        return this;
    }


}

