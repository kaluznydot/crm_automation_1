package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

public class Login_StepDefinitions
{
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();

    @Given("user is on the CRM login page")
    public void user_is_on_the_crm_login_page() {
        Driver.getDriver().get("https://qa.agileprocrm.com/");
    }
    @When("user enters username {string}")
    public void user_enters_username(String username) {
        loginPage.login.sendKeys(username);
    }
    @When("user enters password {string}")
    public void user_enters_password(String pw) {
        loginPage.password.sendKeys(pw);
        loginPage.login_button.click();
    }
    @Then("user should see the Activity Stream page")
    public void user_should_see_the_activity_stream_page() {
        Assert.assertTrue(loginPage.activity_stream_bar.isDisplayed());
    }
    @Then("user should not see the Activity Stream page")
    public void user_should_not_see_the_activity_stream_page() {
        try{
        Assert.assertFalse(loginPage.activity_stream_bar.isDisplayed());
        }
        catch(NoSuchElementException e) {
            Assert.assertTrue(true);
            e.printStackTrace();
        }
    }
    @When("user enters username")
    public void user_enters_username() {
        loginPage.login.sendKeys(faker.letterify("12?34"));
    }
    @When("user enters password")
    public void user_enters_password() {
        loginPage.login.sendKeys(faker.numerify("ab#cd"));
    }
    @Then("user should see the error message {string}")
    public void user_should_see_the_error_message(String string) {
        String actualMessage = loginPage.error_message.getText();
        Assert.assertEquals(string, actualMessage);
    }

}
