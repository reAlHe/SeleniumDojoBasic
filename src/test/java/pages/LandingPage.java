package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class LandingPage {

    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    private WebElement buttonMyAccount;

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    private WebElement linkLogin;

    @FindBy(css = "input[name='search']")
    private WebElement inputSearch;

    @FindBy(xpath = "//a[contains(text(),'Contact Us')]")
    private WebElement linkContactUs;

    @FindBy(xpath = "//*[@id='search']/span/button/i")
    private WebElement buttonStartSearch;

    @FindBy(css = ".product-grid")
    private WebElement gridSearchResults;

    private final WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickButtonMyAccount(){
        buttonMyAccount.click();
        return new LoginPage(driver);
    }

    public void fillInputSearch(String product){
        inputSearch.sendKeys(product);
    }

    public void enterReturnIntoInputSearch(){
        inputSearch.sendKeys(Keys.RETURN);
    }

    public void clickButtonStartSearch(){
        buttonStartSearch.click();
    }

    public LoginPage clickLinkLogin(){
        linkLogin.click();
        return new LoginPage(driver);
    }

    public ContactPage clickLinkContactUs(){
        linkContactUs.click();
        return new ContactPage(driver);
    }

    public void assertThatGridWithResultsIsDisplayed(){
        assertThat(gridSearchResults.isDisplayed()).isTrue();
    }
}
