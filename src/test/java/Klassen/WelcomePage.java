package Klassen;

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

    private WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickSignInButton(){
        signInButton.click();
        return new LoginPage(driver);
    }

}
