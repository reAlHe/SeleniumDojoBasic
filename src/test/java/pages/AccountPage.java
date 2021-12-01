package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountPage {

    @FindBy(xpath = "//a[contains(text(), 'Edit your account information')]")
    private WebElement linkEditInformation;

    private final WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void assertLinkForEditingInformationIsShown(){
        assertThat(linkEditInformation.isDisplayed()).isTrue();
    }
}
