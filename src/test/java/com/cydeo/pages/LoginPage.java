package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    public LoginPage()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder='Login']")
    public WebElement login;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement login_button;

    @FindBy(xpath = "//a[@title='Activity Stream']")
    public WebElement activity_stream_bar;

    @FindBy(xpath = "//div[.='Incorrect login or password']")
    public WebElement error_message;
}
