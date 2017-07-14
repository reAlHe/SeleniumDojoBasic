package Klassen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexanderhe on 14.07.17.
 */
public class ContactPage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "message")
    private WebElement message;

    @FindBy(id = "submitMessage")
    private WebElement submitMessageButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']//ol//li")
    private WebElement errorBox;

    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillEmail(String email){
        emailField.sendKeys(email);
    }

    public void fillMessage(String text){
        message.sendKeys(text);
    }

    public void clickSubmit(){
        submitMessageButton.click();
    }

    public String fetchErrorMessage(){
        return errorBox.getText();
    }
}
