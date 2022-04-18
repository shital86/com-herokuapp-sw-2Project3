package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        // Enter “SuperSecretPassword!” password
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("SuperSecretPassword!");
        //click on log in button
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        //expected result
        String expected = "Secure Area";
        //actual result
        WebElement actual = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/h2[1]"));
        String actualResult = actual.getText();
        //verifying the result
        Assert.assertEquals("Verifying the Result:", expected, actualResult);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith1");
        // Enter “SuperSecretPassword!” password
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("SuperSecretPassword!");
        //click on log in button
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        //expected result
        String expected = "Your username is invalid!\n" +"×";

        //actual result
        WebElement actual = driver.findElement(By.id("flash"));
        String actualResult = actual.getText();
        //verifying the result
        Assert.assertEquals("Verifying the Result:",expected, actualResult);

    }@Test
    public void verifyThePasswordErrorMessage() {

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        // Enter “SuperSecretPassword!” password
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("SuperSecretPassword");
        //click on log in button
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        //expected result
        String expected = "Your password is invalid!\n"+"×";
        //actual result
        WebElement actual = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualResult = actual.getText();
        //verifying the result
        Assert.assertEquals("Verifying the Result:", expected, actualResult);
    }

          @After
    public void tearDown() {
        closeBrowser();
    }


}