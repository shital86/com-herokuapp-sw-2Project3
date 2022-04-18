package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");//no space inbetween path
        driver = new ChromeDriver();
        driver.get(baseUrl);//Launch the Url
        driver.manage().window().maximize();//Maximise window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//we give implicite timeto driver

    }
    public void closeBrowser(){
        driver.quit();

    }
}
