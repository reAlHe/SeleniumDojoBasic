package de.seleniumDojo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by joachimb on 06.07.17.
 */
public class seleniumTests {

    @Test
    public void testAmazonSearchBox(){

        System.setProperty("webdriver.chrome.driver", "/usr/local/Cellar/chromedriver/2.30/bin/chromedriver");
        //final WebDriver driver;

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.de");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.click();

        Assert.assertTrue("search box is not visible", searchBox.isDisplayed());

        driver.close();
        driver.quit();
    }

    @Test
    public void testUebung(){

        WebDriver driver = new ChromeDriver();
        driver.get("http://computer-database.gatling.io/computers");

        WebElement createButton = driver.findElement(By.id("add"));
        createButton.click();

        WebElement inputName = driver.findElement(By.id("name"));
        inputName.sendKeys("Horst");

        //WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"main\"]/form/div/input"));
        WebElement submitButton = driver.findElement(By.cssSelector("input.btn.primary"));
        submitButton.click();

        //WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]"));
        WebElement successMessage = driver.findElement(By.cssSelector("div.alert-message.warning"));

        Assert.assertEquals("wrong success message", successMessage.getText(), "Done! Computer Horst has been created");

        driver.close();
        driver.quit();

    }


}
