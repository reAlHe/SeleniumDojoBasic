package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactPage {

    @FindBy(id = "input-name")
    private WebElement inputName;

    @FindBy(id = "input-enquiry")
    private WebElement inputMessage;

    @FindBy(css = "input[type='submit']")
    private WebElement submitMessageButton;

    @FindBy(xpath = "//div[contains(text(), 'E-Mail Address does not appear to be valid!')]")
    private WebElement errorMessageInvalidEmailAddress;

    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillName(String email){
        inputName.sendKeys(email);
    }

    public void fillMessage(String text){
        inputMessage.sendKeys(text);
    }

    public void clickSubmit(){
        submitMessageButton.click();
    }

    public void assertErrorMessageForInvalidEmailAddressIsShown(){
        assertThat(errorMessageInvalidEmailAddress.isDisplayed()).isTrue();
    }
}
