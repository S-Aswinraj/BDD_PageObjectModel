package StepDefinition;

import Drivers.DriverFactory;
import Pages.LoginPage;
import com.amazonaws.services.dynamodbv2.xspec.S;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginSteps  {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    String HomepageURL = "https://bookcart.azurewebsites.net/";


    @Given("User is in book cart homepage")
    public void userIsInBookCartHomepage() {

        System.out.println("you are in homepage");



    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.Click_homeLogin();


    }

    @When("user inputting valid credentials username {string} password {string}")
    public void userInputtingValidCredentialsUsernamePassword(String username, String password) {
        loginPage.input_Username(username);
        loginPage.input_password(password);
        loginPage.Click_Afterpass();



    }

    @Then("login should be successful")
    public void loginShouldBeSuccessful() {

        Assert.assertEquals(loginPage.WebelementAfterLogin().isDisplayed(),false);
    }

    @Then("user quit browser")
    public void userQuitBrowser() {
//        driver.quit();
    }



    @When("Login should fail")
    public void loginShouldFail() {


        Assert.assertEquals(loginPage.FailedLogin(),"Username or Password is incorrect.");
        System.out.println(loginPage.FailedLogin());
    }
}
