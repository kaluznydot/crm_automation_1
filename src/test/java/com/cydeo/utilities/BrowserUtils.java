package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils
{
    /*
    This method will accept int (in seconds) and execute Thread.sleep for given duration
     */
    public static void sleep (int second)
    {
        second *= 1000;

        try
        {
            Thread.sleep(second);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle)
    {
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String eachHandle : allWindowHandles)
        {
            Driver.getDriver().switchTo().window(eachHandle);
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl))
            {
                break;
            }
        }
        //Assert: Title contains "expectedTitle"
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    //This method accepts a String "expectedTitle" and Asserts if it is true
    public static void verifyTitle(String expectedTitle)
    {
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    public static void waitForInvisibilityOf(WebElement webElement)
    {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public static void verifyURLContains(String expectedInURL)
    {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    public static List<String> dropdownOptionsAsString(WebElement dropdownElement)
    {
        Select select = new Select(dropdownElement);
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        List<String> actualOptionsAsString = new ArrayList<>();
        for (WebElement each : actualOptionsAsWebElement)
        {
            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue)
    {
        for (WebElement radioButton : radioButtons)
        {
            if(radioButton.getAttribute("value").equalsIgnoreCase(attributeValue))
            {
                radioButton.click();
            }
        }
    }
}
