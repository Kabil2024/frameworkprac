package test;
import com.beust.jcommander.Parameter;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginScreen;
import utils.DataProviderUtility;
import utils.Log;

import java.net.PasswordAuthentication;

public class LoginTest extends BaseTest{

    @Test(dataProvider = "loginData" , dataProviderClass = DataProviderUtility.class)
    public void loginTest(String username, String password) throws InterruptedException {
        //LoginScreen ls = new LoginScreen(driver);
        System.out.println("Logging in with: " + username + " / " + password);
        // Selenium login logic goes here...
        //ls.login(username, password);
    }

    //@Test
    @Parameters({"browser"})
    void login(String brow) throws InterruptedException {
        if(brow.equals("chrome")){

        }
        Log.info("info log");
        LoginScreen ls = new LoginScreen(getDriver());//
        ls.login("student", "Password123");
        Thread.sleep(2000);
    }

    //@Test
    void loginwithInvalid() throws InterruptedException {
        LoginScreen ls = new LoginScreen(getDriver());//
        String usern = generateRandomString(5)+"@gmail.com";
        String PAASN = generateRandomNumber(5);
        System.out.println(usern +"-"+ PAASN);
        ls.login(usern, PAASN);
    }

}
