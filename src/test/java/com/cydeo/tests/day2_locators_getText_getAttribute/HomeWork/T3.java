package com.cydeo.tests.day2_locators_getText_getAttribute.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3 {

    public static void main(String[] args) {

        //TC #3: Back and forth navigation
        // 1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.navigate().forward();



        //2- Go to: https://google.com
        driver.navigate().to("https://google.com");

        //agree button
        WebElement agreeButton=driver.findElement(By.id("L2AGLb"));
        agreeButton.click();

        //3- Click to Gmail from top right.
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        gmailLink.click();

        // 4- Verify title contains:
        //Expected: Gmail
        String expectedTitleGmail = "Gmail";
        String actualTitleGmail = driver.getTitle();

        if (actualTitleGmail.equals(expectedTitleGmail)){
            System.out.println("Title verification Gmail PASS");
        }else {
            System.out.println("Title verification Gmail FAILED");
        }

        //5- Go back to Google by using the .back();
        driver.navigate().back();

        // 6- Verify title equals:
        //Expected: Google
        String expectedTitleGoogle = "Google";
        String actualTitleGoogle = driver.getTitle();

        if (actualTitleGoogle.equals(expectedTitleGoogle)){
            System.out.println("Title verification Google PASS");
        }else {
            System.out.println("Title verification Google FAILED");
        }

       driver.close();
    }

}
