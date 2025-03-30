package test;
import com.beust.jcommander.Parameter;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod(groups = {"Sanity","Regression"})
    @Parameter
    public void setUp() throws MalformedURLException, InterruptedException {
//        String huburl = "http://localhost:4444/wd/hub";
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setBrowserName("chrome");
//        driver = new RemoteWebDriver(new URL(huburl), cap);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver.set(new ChromeDriver(options));
    }

    @AfterMethod(groups = {"Sanity","Regression"})
    public void close(){
        getDriver().quit();
        driver.remove();
    }

    public String generateRandomString(int lenght){
        String randomString = RandomStringUtils.randomAlphanumeric(lenght);
        return randomString;
    }

    public String generateRandomNumber(int lenght){
        String randomString = RandomStringUtils.randomNumeric(lenght);
        return randomString;
    }

}
