package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginScreen {

    //with pagefactory
    WebDriver driver;
    //constructor
    public LoginScreen(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //locators
    @FindBy(xpath = "//*[@id='username']")
    WebElement user_input;

    @FindBy(xpath = "//input[@id='password']")
    WebElement pass_input;
    //By pass_input = By.cssSelector("#password");
    //By submit_button = By.cssSelector("#submit");
    @FindBy(xpath = "//button[@id='submit']")
    WebElement submit_button;



    //action methods
    public void login(String username, String passowrd) throws InterruptedException {
        user_input.sendKeys(username);
        pass_input.sendKeys(passowrd);
        //sThread.sleep(4000);
        submit_button.click();
        System.out.println("login done");
    }
}
