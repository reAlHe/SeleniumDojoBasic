package swissq.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static Target INPUT_EMAIL = Target.the("email field").located(By.id("input-email"));
    public static Target INPUT_PASSWORD = Target.the("password field").located(By.id("input-password"));
    public static Target BUTTON_LOGIN = Target.the("button 'Login'").locatedBy("//input[@value='Login']");
    public static Target ERROR_MESSAGE = Target.the("error message").locatedBy("//div[contains(text(), '{0}')]");
}
