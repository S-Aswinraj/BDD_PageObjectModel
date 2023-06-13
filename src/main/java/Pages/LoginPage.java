package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    // By locator
    private By Login_button = By.xpath("//span[contains(text(),'Login')]");
    private By UserName_textbox = By.id("mat-input-0");
    private By Password_textbox = By.id("mat-input-1");
    private By Login_Afterpass = By.xpath("(//span[contains(text(),'Login')])[2]");
    private By AssetAfterLogin = By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]");
    private By Login_error = By.xpath("//mat-error[@class='mat-error ng-star-inserted']");

    //constructor of the page class
    public LoginPage(WebDriver driver){
        this.driver =driver;
    }
    //page action(Methods)

    public void Click_homeLogin(){
        driver.findElement(Login_button).click();

    }
    public void Click_Afterpass(){
        driver.findElement(Login_Afterpass).click();
    }

    public void input_Username(String username){
        driver.findElement(UserName_textbox).sendKeys(username);

    }
    public void input_password(String password){
        driver.findElement(Password_textbox).sendKeys(password);
    }

    public WebElement WebelementAfterLogin(){
        WebElement element_Login = driver.findElement(AssetAfterLogin);
        return element_Login;
    }

    public String FailedLogin(){
        String Login_error =driver.findElement(By.xpath("//mat-error[@class='mat-error ng-star-inserted']")).getText();
        return Login_error;
    }


}
