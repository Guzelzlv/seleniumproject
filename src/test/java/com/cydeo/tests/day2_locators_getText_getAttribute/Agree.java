package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Agree {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        //agree button goggle
        WebElement agreeButton=driver.findElement(By.id("L2AGLb"));
        agreeButton.click();


        //agreeButton.click();
       driver.findElement(By.xpath("//button[@class = 'wt-btn wt-btn--filled wt-mb-xs-0']")).click();

    }
}
