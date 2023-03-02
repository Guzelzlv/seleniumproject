package com.cydeo.tests.day5_testNG_intro_dropdowns.HomeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC5 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        //TC #5: Selecting state from State dropdown and verifying result
        // 1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void simpleDropDownTest() {

        // Finds select tag with "state" id
        Select states = new Select(driver.findElement(By.cssSelector("#state")));

        //3. Select Illinois
        states.selectByIndex(14);

        //4. Select Virginia
        states.selectByValue("VA");

        //5. Select California
        states.selectByVisibleText("California");

        //6. Verify final selected option is California.
        String expectedSelectedOption = "California";
        String actualSelectedOption = states.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedSelectedOption, actualSelectedOption);


        //Use all Select options. (visible text, value, index)
    }
}
