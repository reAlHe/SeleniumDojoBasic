package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage {

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(css = "input[value='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(), 'Warning: No match for E-Mail Address and/or Password.')]")
    private WebElement errorMessageInvalidCredentials;

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillEmail(String username){
        inputEmail.sendKeys(username);
    }

    public void fillPassword(String pwd){
        inputPassword.sendKeys(pwd);
    }

    public AccountPage clickButtonLogin(){
        loginButton.click();
        return new AccountPage(driver);
    }

    public void assertErrorMessageForInvalidCredentialsIsShown(){
        assertThat(errorMessageInvalidCredentials.isDisplayed()).isTrue();
    }
}
