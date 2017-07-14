package Klassen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexanderhe on 14.07.17.
 */
public class AccountPage {

    @FindBy(css = "p.info-account")
    private WebElement welcomeText;

    public AccountPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String fetchWelcomeText(){
        return welcomeText.getText();
    }
}
