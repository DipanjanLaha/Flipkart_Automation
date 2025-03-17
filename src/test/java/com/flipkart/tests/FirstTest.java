package com.flipkart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Scanner;

public class FirstTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        String jsScript = "window.scrollBy(0,500);";
        ((JavascriptExecutor)driver).executeScript(jsScript);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit(); // this closes all the windows
        //driver.close(); //this closes only one window
    }

    @Test
    public void TestLoggingIntoApplication() throws InterruptedException {
        WebElement username = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input"));
        username.sendKeys("9735731772");

        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button")).click();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the OTP: ");
        String otp = scanner.nextLine();
        scanner.close();

        List<WebElement> otpInputs = driver.findElements(By.cssSelector("input.r4vIwl.IX3CMV"));

        for (int i = 0; i < otp.length(); i++) {
            otpInputs.get(i).sendKeys(String.valueOf(otp.charAt(i)));
        }

    }
}
