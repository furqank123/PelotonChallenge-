package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignIn {
    @FindBy(css = "a.sc-exkUMo:nth-child(3) > svg:nth-child(1) > path:nth-child(1)")
    public static WebElement burgerMenu;//burgerMenu in reference to the three dashes menu that looks like a burger

    @FindBy(css = "div.sc-dxZgTM:nth-child(3) > a:nth-child(1)")
    public static WebElement burgerMenuSignIn;

    @FindBy(css = "div.form__row:nth-child(2) > input:nth-child(1)")
    public static WebElement emailOrUserName;

    @FindBy(css = "div.form__row:nth-child(3) > input:nth-child(1)")
    public static WebElement passwordField;

    @FindBy(css = ".pelo-btn-1")
    public static WebElement signIn;

    @FindBy(css = ".sc-jtRlXQ")
    public static WebElement menuLoggedIn;

    @FindBy(css = "div.sc-clNaTc:nth-child(4) > span:nth-child(1)")
    public static WebElement logOut;

    @FindBy(css = "div.form__error:nth-child(1)")
    public static WebElement genericSignInError;

    public SignIn clickOnBurgerMenu() {
        burgerMenu.isDisplayed();
        burgerMenu.click();
        return this;
    }

    public SignIn clickOnBurgerMenuSignIn() {
        burgerMenuSignIn.isDisplayed();
        burgerMenuSignIn.click();
        return this;
    }

    public SignIn enterEmailOrUserName(String identity){
        emailOrUserName.isDisplayed();
        emailOrUserName.sendKeys(identity);
        return this;
    }

    public SignIn enterPassword(String password){
        passwordField.isDisplayed();
        passwordField.sendKeys(password);
        return this;
    }

    public SignIn clickOnSignIn() {
        signIn.isDisplayed();
        signIn.click();
        return this;
    }

    public SignIn clickOnMenuLoggedIn() {
        menuLoggedIn.isDisplayed();
        menuLoggedIn.click();
        return this;
    }

    public SignIn clickOnLogOut() {
        logOut.isDisplayed();
        logOut.click();
        return this;
    }

    public SignIn signInGenericErrorIsDisplayed(){
        genericSignInError.isDisplayed();
        return this;
    }


}
