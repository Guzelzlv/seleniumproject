package com.cydeo.tests.day5_testNG_intro_dropdowns.HomeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC8 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC #8: Selecting value from multiple select dropdown
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void multipleSelectDropdown() {
        //3. Select all the options from multiple select dropdown.
        Select multipleDropDown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        //store all options
        List<WebElement> options = multipleDropDown.getOptions();
        // this will iterate according to size of options
        for (int i = 0; i < options.size(); i++) {
            // this will select by index one by one
            multipleDropDown.selectByIndex(i);
        }
        //4. Print out all selected values.
        // stores all selected options
        List<WebElement> selectedOptions = multipleDropDown.getAllSelectedOptions();
        // iterates each element of selected options
        for (WebElement each : selectedOptions) {
            // prints each selected options
            System.out.println(each.getText());
        }
        //5. Deselect all values.
        multipleDropDown.deselectAll();

    }
}
