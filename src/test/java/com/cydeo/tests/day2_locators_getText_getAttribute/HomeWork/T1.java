package com.cydeo.tests.day2_locators_getText_getAttribute.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1 {
    public static void main(String[] args) {

        //TC #1: Etsy Title Verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://www.etsy.com
        driver.navigate().to("https://www.etsy.com ");


        //agree button
       // WebElement agreeButton=driver.findElement(By.id("L2AGLb"));
        //agreeButton.click();
        driver.findElement(By.xpath("//button[@class = 'wt-btn wt-btn--filled wt-mb-xs-0']")).click();


        // 3. Search for “wooden spoon”
        WebElement searchWord = driver.findElement(By.name("search_query"));
        searchWord.sendKeys("Wooden spoon"+ Keys.ENTER);

        // 4. Verify title:
        //Expected: “Wooden spoon | Etsy”
        String expectedInTitle= "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedInTitle)){
            System.out.println("Title verification PASS!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }
        driver.close();
    }
}
