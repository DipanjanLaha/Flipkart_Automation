package com.flipkart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FirstTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/account/login?ret=/");
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search for Products, Brands and More']")));

        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
        searchBox.click();
        searchBox.sendKeys("Iphone 16");
        driver.findElement(By.xpath("//button[@aria-label='Search for Products, Brands and More']")).click();

        driver.findElement(By.xpath("(//a[contains(@href, '/p/')])[2]")).click();

        //driver.findElement(By.xpath("//button[text()='Buy Now']")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windowHandles);

        driver.switchTo().window(windowList.get(1));

        driver.findElement(By.xpath("//button[text()='Buy Now']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Deliver Here']")));
        driver.findElement(By.xpath("//button[text()='Deliver Here']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='CONTINUE']")));

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter your email ID']")));
        //WebElement verification_email = driver.findElement(By.xpath("//input[@placeholder='Enter your email ID']"));
        //verification_email.click();
        //verification_email.sendKeys("technicalsubham2001@gmail.com");

        WebElement continueSection = driver.findElement(By.xpath("//button[text()='CONTINUE']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueSection);
        driver.findElement(By.xpath("//button[text()='CONTINUE']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Accept & Continue']")));

        By acceptContinueButtonLocator = By.xpath("//button[text()='Accept & Continue']");

        if (!driver.findElements(acceptContinueButtonLocator).isEmpty()) {
            WebElement acceptContinueButton = wait.until(ExpectedConditions.elementToBeClickable(acceptContinueButtonLocator));
            acceptContinueButton.click();
        } else {
            System.out.println("'Accept & Continue' button not found.");
        }

        /*wait.wait(2000);
        //WebElement upiLabel = driver.findElement(By.xpath("//label[@for='UPI']"));
        //upiLabel.click();

        //WebElement yourUpiIdLabel = driver.findElement(By.xpath("//label[@for='UPI_COLLECT']"));
        //yourUpiIdLabel.click();

        //wait.wait(2000);

        //WebElement upiIdField = driver.findElement(By.xpath("//input[@name='upi-id']"));*/

        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        WebElement creditSection = driver.findElement(By.xpath("//label[@for='CREDIT']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", creditSection);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement creditCardRadio = driver.findElement(By.xpath("//label[@for='CREDIT']"));
        creditCardRadio.click();

        WebElement cardNumberInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='cardNumber']")));
        cardNumberInput.sendKeys("4111111111111111");

        WebElement monthDropdown = driver.findElement(By.xpath("//select[@name='month']"));
        Select selectMonth = new Select(monthDropdown);

        selectMonth.selectByValue("12");

        WebElement yearDropdown = driver.findElement(By.xpath("//select[@name='year']"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByValue("28");

        WebElement cvvInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@autocomplete='cc-csc']")));
        cvvInput.sendKeys("123");

        WebElement pin_code = driver.findElement(By.xpath("//input[@name='billing_pincode']"));
        pin_code.sendKeys("700012");

        WebElement countryDropdown = driver.findElement(By.xpath("//select[@name='billing_country']"));
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText("India");

        WebElement city = driver.findElement(By.xpath("//input[@name='billing_city']"));
        city.sendKeys("Kolkata");

        WebElement state = driver.findElement(By.xpath("//input[@name='billing_state']"));
        state.sendKeys("West Bengal");

        WebElement address = driver.findElement(By.xpath("//textarea[@name='billing_address']"));
        address.sendKeys("Kolkata, West Bengal, 700012");

        WebElement payButton = driver.findElement(By.xpath("//button[contains(text(), 'PAY ₹74,999')]"));
        payButton.click();

        String checkout = driver.findElement(By.xpath("//span[text()='Price details']")).getText();
        String expctedString = "Price details";
        Assert.assertEquals(checkout, expctedString);
    }
}
