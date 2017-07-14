package Klassen;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexanderhe on 07.07.17.
 */
public class WelcomePage {

    @FindBy(css = "a.login")
    private WebElement signInButton;

    @FindBy(id = "search_query_top")
    private WebElement searchField;

    @FindBy(css = "button.btn.btn-default.button-search")
    private WebElement searchButton;

    @FindBy(id = "contact-link")
    private WebElement contactButton;

    private WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickSignInButton(){
        signInButton.click();
        return new LoginPage(driver);
    }

    public void fillProductSearch(String product){
        searchField.sendKeys(product);
    }

    public SearchResultPage sendReturnToSearchField(){
        searchField.sendKeys(Keys.RETURN);
        return new SearchResultPage(driver);
    }

    public SearchResultPage clickSearchButton(){
        searchButton.click();
        return new SearchResultPage(driver);
    }

    public ContactPage clickOnContactUs(){
        contactButton.click();
        return new ContactPage(driver);
    }

}
