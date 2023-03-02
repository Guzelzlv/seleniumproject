package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_SimpleDropdowns {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

//1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        //Maximize the page
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void simpleDropDownTest() {

//3. Verify “Simple dropdown” default selected value is correct
        Select simpleDropDown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        WebElement currentlySelectedOption = simpleDropDown.getFirstSelectedOption();

        String actualSimpleDropDownText = currentlySelectedOption.getText();

        String expectedSimpleDropDownText = "Please select an option";

        //Expected: “Please select an option”
        Assert.assertEquals(actualSimpleDropDownText,expectedSimpleDropDownText);

//4. Verify “State selection” default selected value is correct
        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

//Expected: “Select a State”
        String expectedStateDropDownText = "Select a State";

        String actualStateDropDownText = stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualStateDropDownText, expectedStateDropDownText);

        //Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(), "Select a State");

    }
}
