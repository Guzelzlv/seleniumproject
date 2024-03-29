package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getText {

    public static void main(String[] args) {

        //TC #1: NextBaseCRM, locators and getText() practice
        // 1- Open a Chrome browser
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.navigate().to("https://login1.nextbasecrm.com");

        //3- Enter incorrect username: “incorrect”
        //driver.findElement(By.className("login-inp")).sendKeys("incorrect");
        WebElement inputUserName = driver.findElement(By.className("login-inp"));
        inputUserName.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD")); //option+Enter to autogenerate local variable
        inputPassword.sendKeys("incorrect");

        //5- Click to login button.
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        WebElement errorMessage = driver.findElement(By.className("errortext"));

        String expectedErrorMessage = "Incorrect login or password";
        String actualMessage =errorMessage.getText();

        if (actualMessage.equals(expectedErrorMessage)) {
            System.out.println("Error message verification PASSED!");
        }else{
            System.out.println("Error message verification FAILED!!!");
        }

        //PS: Inspect and decide which locator you should be using to locate web elements.
    }
}
