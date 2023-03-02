package com.cydeo.tests.day5_testNG_intro_dropdowns.HomeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC7 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC #7: Selecting value from non-select dropdown
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }


    @Test
    public void selectingValueFromNonSelectDropdown() {

        //3. Click to non-select dropdown
        //WebElement nonSelect = driver.findElement(By.xpath("//select[@id='dropdown']"));
        //nonSelect.click();
        WebElement nonSelectDropdown = driver.findElement(By.cssSelector("#dropdownMenuLink"));
        nonSelectDropdown.click();

        //4. Select Facebook from dropdown
        WebElement facebook = driver.findElement(By.linkText("Facebook"));
        facebook.click();

        //5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";

        // Test fails, because actual title is "Facebook – log in or sign up"
        Assert.assertEquals(actualTitle,expectedTitle);

    }
}
