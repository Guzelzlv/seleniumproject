package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class t1_2 {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void window_handling_test(){
        //2. Go to: https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3. Copy-paste the lines from below into your class
      ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {
           if (!each.equals(currentWindow)){
                driver.switchTo().window(each);
            }

        }
        WebElement agreeButton=driver.findElement(By.id("L2AGLb"));
        agreeButton.click();

        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");

        allWindowHandles = driver.getWindowHandles();

        currentWindow = driver.getWindowHandle();

        for (String each : allWindowHandles) {
            if (!each.equals(currentWindow)){
                driver.switchTo().window(each);
            }
        }
        WebElement agreeButton2=driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-mb-xs-0']"));
        agreeButton2.click();

        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");
        allWindowHandles = driver.getWindowHandles();

        currentWindow = driver.getWindowHandle();

        for (String each : allWindowHandles) {
            if (!each.equals(currentWindow)){
                driver.switchTo().window(each);
            }
        }
        WebElement agreeButton3=driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']"));
        agreeButton3.click();
        //4. Create a logic to switch to the tab where Etsy.com is open

        BrowserUtils.switchWindowAndVerify(driver, "etsy", "Etsy");
    }
}