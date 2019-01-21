package Base;

import PageObjects.AddBikeToCart;
import PageObjects.SignIn;
import Utils.TestData;
import Utils.TestDataUtil;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BaseComponent {

    private static WebDriver driver = null;
    private static BaseComponent instance;
    private TestDataUtil testDataUtil = new TestDataUtil();
    private TestData validLogIn = testDataUtil.retrieveValidLogIn();
    private TestData validPasswords = testDataUtil.retrieveValidPasswords();
    private TestData invalidPasswords = testDataUtil.retrieveInvalidPasswords();
    private TestData invalidEmail = testDataUtil.retrieveInvalidLogIn();





    public static BaseComponent getInstance() {
        if (instance == null) {
            instance = new BaseComponent();
        }

        return instance;
    }


    @Before
    public void setUp() {
        TestDataUtil data = new TestDataUtil();
        TestData sessionData = data.retrieveHomePage();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get(sessionData.getFirstURL());

    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    public BaseComponent addBikeToCart() {
        AddBikeToCart addBikeToCart = PageFactory.initElements(driver, AddBikeToCart.class);
        addBikeToCart.tapOnBike()
                .clickOnBuyTheBike()
                .clickOnShopNow()
                .clickOnAddToCart()
                .verifyCartIsLaunched();

        return this;
    }

    public BaseComponent logInValidEmailAndUserName() {
        SignIn signIn = PageFactory.initElements(driver, SignIn.class);
        signIn.clickOnBurgerMenu()
                .clickOnBurgerMenuSignIn()
                .enterEmailOrUserName(this.validLogIn.getValidEmailOne())
                .enterPassword(this.validPasswords.getValidPasswordOne())
                .clickOnSignIn()
                .clickOnMenuLoggedIn()
                .clickOnLogOut()
                .enterEmailOrUserName(this.validLogIn.getValidUserNameOne())
                .enterPassword(this.validPasswords.getValidPasswordOne())
                .clickOnSignIn()
                .clickOnMenuLoggedIn(); //Just a check to see if login was successful

        return this;
    }

    public BaseComponent logInInvalidPasswordValidEmail(){
        SignIn signIn = PageFactory.initElements(driver, SignIn.class);
        signIn.clickOnBurgerMenu()
                .clickOnBurgerMenuSignIn()
                .enterEmailOrUserName(this.validLogIn.getValidEmailTwo())
                .enterPassword(this.invalidPasswords.getInValidPasswordOne())
                .clickOnSignIn()
                .signInGenericErrorIsDisplayed();

        return this;
    }

    public BaseComponent logInInvalidPasswordValidUserName(){
        SignIn signIn = PageFactory.initElements(driver, SignIn.class);
        signIn.clickOnBurgerMenu()
                .clickOnBurgerMenuSignIn()
                .enterEmailOrUserName(this.validLogIn.getValidEmailTwo())
                .enterPassword(this.invalidPasswords.getInValidPasswordOne())
                .clickOnSignIn()
                .signInGenericErrorIsDisplayed();

        return this;
    }

    public BaseComponent logInInvalidEmailInvalidPassword(){
        SignIn signIn = PageFactory.initElements(driver, SignIn.class);
        signIn.clickOnBurgerMenu()
                .clickOnBurgerMenuSignIn()
                .enterEmailOrUserName(this.invalidEmail.getInValidEmailOne())
                .enterPassword(this.invalidPasswords.getInValidPasswordOne())
                .clickOnSignIn()
                .signInGenericErrorIsDisplayed();
        return this;
    }

    public BaseComponent logInInvalidUserNameInvalidPassword(){
        SignIn signIn = PageFactory.initElements(driver, SignIn.class);
        signIn.clickOnBurgerMenu()
                .clickOnBurgerMenuSignIn()
                .enterEmailOrUserName(this.invalidEmail.getInvalidUserName())
                .enterPassword(this.invalidPasswords.getInValidPasswordOne())
                .clickOnSignIn()
                .signInGenericErrorIsDisplayed();
        return this;
    }
}
