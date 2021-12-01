import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingTestWithoutPageObjects {

    private ChromeDriver driver;

    @BeforeClass
    public static void setupWebDriverManager(){
        ChromeDriverManager.chromedriver();
    }

    @BeforeMethod
    public void initTest(){
        driver = new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/index.php");
    }

    @AfterMethod
    public void tearDownTest() {
        driver.quit();
    }

    @Test
    public void loginWithValidCredentialsShouldBeSuccessful() {
        driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        driver.findElement(By.id("input-email")).sendKeys("vixeka1671@dukeoo.com");
        driver.findElement(By.id("input-password")).sendKeys("12345Test");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        assertThat(driver.findElement(By.xpath("//a[contains(text(), 'Edit your account information')]")).isDisplayed()).isTrue();
    }

    @Test
    public void loginWithInvalidCredentialsShouldThrowAnAlert() {
        driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        driver.findElement(By.id("input-email")).sendKeys("badguy@bluewin.ch");
        driver.findElement(By.id("input-password")).sendKeys("wrongPw");
        driver.findElement(By.cssSelector("input[value='Login']")).click();

        assertThat(driver.findElement(By.xpath("//div[contains(text(), 'Warning: No match for E-Mail Address and/or Password.')]")).isDisplayed()).isTrue();
    }

    @Test
    public void searchForProductBySendingReturn() {
        driver.findElement(By.cssSelector("input[name='search']")).sendKeys("iPhone");
        driver.findElement(By.cssSelector("input[name='search']")).sendKeys(Keys.RETURN);

        assertThat(driver.findElement(By.cssSelector(".product-grid")).isDisplayed()).isTrue();

    }

    @Test
    public void searchForProductByClickingSearchButton() {
        driver.findElement(By.cssSelector("input[name='search']")).sendKeys("iPhone");
        driver.findElement(By.xpath("//*[@id='search']/span/button/i")).click();

        assertThat(driver.findElement(By.cssSelector(".product-grid")).isDisplayed()).isTrue();
    }

    @Test
    public void sendContactMessageWithoutEmailShouldFail() {
        driver.findElement(By.xpath("//a[contains(text(),'Contact Us')]")).click();
        driver.findElement(By.id("input-name")).sendKeys("Tom Tester");
        driver.findElement(By.id("input-enquiry")).sendKeys("Hello, this text contains at least 10 characters.");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        assertThat(driver.findElement(By.xpath("//div[contains(text(), 'E-Mail Address does not appear to be valid!')]")).isDisplayed()).isTrue();
    }
}
