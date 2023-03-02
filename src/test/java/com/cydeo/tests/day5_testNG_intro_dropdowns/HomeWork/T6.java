package com.cydeo.tests.day5_testNG_intro_dropdowns.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class T6 {

    //TC #6: Selecting date on dropdown and verifying

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();

        //1. Open Chrome browser
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void selectingDateDropdownTest(){

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        //3. Select “December 1st, 1923” and verify it is selected.
        Select month = new Select(driver.findElement(By.cssSelector("select#month")));
        Select day = new Select(driver.findElement(By.cssSelector("select#day")));
        Select year = new Select(driver.findElement(By.cssSelector("select#year")));

        //Select year using : visible text
        // Since there is no such a year in the dropdown, it throws NoSuchElementException
        // To be able to get execute the rest of the code, we have to handle this exception
        try {
            year.selectByVisibleText("1923");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        //Select month using : value attribute
        month.selectByValue("11");

        //Select day using : index number
        day.selectByIndex(0);

        // verify it is selected
        String expectedDay = "1";
        String expectedMonth = "December";
        String expectedYear = "1923";

        String actualDay = day.getFirstSelectedOption().getText();
        String actualMonth = month.getFirstSelectedOption().getText();
        String actualYear = year.getFirstSelectedOption().getText();

        Assert.assertEquals(actualDay,expectedDay);
        Assert.assertEquals(actualMonth,expectedMonth);
        // Because of the exception, default year (2023) remains and test fails.
        Assert.assertEquals(actualYear,expectedYear);

    }

}