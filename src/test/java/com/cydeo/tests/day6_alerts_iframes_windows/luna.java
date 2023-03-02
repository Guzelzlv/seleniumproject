package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class luna {
        WebDriver driver;

        @BeforeMethod
        public void setupMethod() {
            //1. Open browser
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //2. Go to website: http://practice.cydeo.com/javascript_alerts
            driver.get("https://www.flipkart.com/");
        }
//_2KpZ6l _2doB4z
        @Test
        public void alert_test1() {
            WebElement dismissBtn = driver.findElement(By.xpath("//input[@class='_3704LK']"));
            dismissBtn.click();
        }
}
