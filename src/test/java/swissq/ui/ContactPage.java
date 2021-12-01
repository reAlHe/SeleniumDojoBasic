package swissq.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ContactPage {
    public static Target INPUT_NAME = Target.the("name field").located(By.id("input-name"));
    public static Target INPUT_MESSAGE = Target.the("message field").located(By.id("input-enquiry"));
    public static Target BUTTON_SUBMIT_MESSAGE = Target.the("button 'Submit'").locatedBy("//input[@type='submit']");
    public static Target ERROR_MESSAGE = Target.the("error message").locatedBy("//div[contains(text(), '{0}')]");
}
