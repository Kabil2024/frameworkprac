package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeScreen {

    WebDriver driver;
    //constructor
    public HomeScreen(WebDriver driver){
        this.driver = driver;
    }

    //locator
    By logout_button = By.xpath("//a[text()='Log out']");

    //actionmethod
    public void logout(){
        driver.findElement(logout_button).click();
        System.out.println("logout done");
    }

}
