package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomeScreen;
import pages.LoginScreen;
import utils.Log;

public class HomeScreenTest extends BaseTest{

    @Test(groups = "Sanity")
    void verifyHomescreen() throws InterruptedException {
        getDriver().get("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(5000);
        getDriver().manage().window().maximize();
        LoginScreen ls = new LoginScreen(getDriver());
        HomeScreen hs = new HomeScreen(getDriver());
        generateRandomNumber(5);
        ls.login("student", "Password123");
        getDriver().findElement(By.xpath("//h1[text()='Logged In Successfully']")).isDisplayed();
        hs.logout();
    }

    @Test
    void verifyBing() throws InterruptedException {
        getDriver().get("https://www.facebook.com");
        getDriver().manage().window().maximize();
        System.out.println(getDriver().getCurrentUrl());
        System.out.println("Title - "+ getDriver().getTitle());
    }
}
