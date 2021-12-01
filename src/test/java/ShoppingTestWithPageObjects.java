import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.ContactPage;
import pages.LandingPage;
import pages.LoginPage;

public class ShoppingTestWithPageObjects {

    private ChromeDriver driver;

    @BeforeClass
    public static void setupWebDriverManager(){
        ChromeDriverManager.chromedriver();
    }

    @BeforeMethod
    public void initTest(){
        driver = new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/index.php");
    }

    @AfterMethod
    public void tearDownTest() {
        driver.quit();
    }

    @Test
    public void loginWithValidCredentialsShouldBeSuccessful() {
        LandingPage homePage = new LandingPage(driver);
        homePage.clickButtonMyAccount();
        LoginPage loginPage = homePage.clickLinkLogin();
        loginPage.fillEmail("vixeka1671@dukeoo.com");
        loginPage.fillPassword("12345Test");
        AccountPage accountPage = loginPage.clickButtonLogin();
        accountPage.assertLinkForEditingInformationIsShown();
    }

    @Test
    public void loginWithInvalidCredentialsShouldThrowAnAlert() {
        LandingPage homePage = new LandingPage(driver);
        homePage.clickButtonMyAccount();
        LoginPage loginPage = homePage.clickLinkLogin();
        loginPage.fillEmail("badguy@bluewin.ch");
        loginPage.fillPassword("wrongPw");
        loginPage.clickButtonLogin();
        loginPage.assertErrorMessageForInvalidCredentialsIsShown();
    }

    @Test
    public void searchForProductBySendingReturn() {
        LandingPage homePage = new LandingPage(driver);
        homePage.fillInputSearch("iPhone");
        homePage.enterReturnIntoInputSearch();
        homePage.assertThatGridWithResultsIsDisplayed();
    }

    @Test
    public void searchForProductByClickingSearchButton() {
        LandingPage homePage = new LandingPage(driver);
        homePage.fillInputSearch("iPhone");
        homePage.clickButtonStartSearch();
        homePage.assertThatGridWithResultsIsDisplayed();
    }

    @Test
    public void sendContactMessageWithoutEmailShouldFail() {
        LandingPage homePage = new LandingPage(driver);
        ContactPage contactPage = homePage.clickLinkContactUs();
        contactPage.fillName("Tom Tester");
        contactPage.fillMessage("Hello, this text contains at least 10 characters.");
        contactPage.clickSubmit();
        contactPage.assertErrorMessageForInvalidEmailAddressIsShown();
    }
}
