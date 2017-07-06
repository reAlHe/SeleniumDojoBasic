import org.hamcrest.core.Is;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by alexanderhe on 06.07.17.
 */
public class ShoppingTest {

    @Test
    public void loginWithValidCredentialsShouldBeSuccessfullTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
        driver.findElementByCssSelector("a.login").click();
        driver.findElementById("email").sendKeys("rianamahliadewi@gmail.com");
        driver.findElementById("passwd").sendKeys("lalayeyeye");
        driver.findElementById("SubmitLogin").click();
        String welcomeText = driver.findElementByCssSelector("p.info-account").getText();
        assertThat(welcomeText, is(equalTo("Welcome to your account. Here you can manage all of your personal information and orders.")));
        driver.quit();
    }

    @Test
    public void loginWithInvalidCredentialsShouldThrowAnAlertTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
        driver.findElementByCssSelector("a.login").click();
        driver.findElementById("email").sendKeys("invalidEmail@gmail.com");
        driver.findElementById("passwd").sendKeys("wrongPassword");
        driver.findElementById("SubmitLogin").click();
        String errorText = driver.findElementByXPath("//div[@class='alert alert-danger']//ol//li").getText();
        assertThat(errorText, is(equalTo("Authentication failed.")));
        driver.quit();
    }

    @Test
    public void searchForProductBySendingReturn() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
        driver.findElementById("search_query_top").sendKeys("dress");
        driver.findElementById("search_query_top").sendKeys(Keys.RETURN);
        List<WebElement> products = driver.findElementsByXPath("//ul[@class='product_list grid row']//li");
        assertThat(products.size(), is(greaterThan(1)));
        driver.quit();
    }

    @Test
    public void searchForProductByClickingSearchButton() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
        driver.findElementById("search_query_top").sendKeys("dress");
        driver.findElementByCssSelector("button.btn.btn-default.button-search").click();
        List<WebElement> products = driver.findElementsByXPath("//ul[@class='product_list grid row']//li");
        assertThat(products.size(), is(greaterThan(1)));
        driver.quit();
    }
}
