package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {


    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "10.0");
        desiredCapabilities.setCapability("deviceName", "Pixel 3");
        //android apps have .apk extension
        //file can be stored locally or in a cloud storage
        desiredCapabilities.setCapability("app", "https://cybertek-appium.s3.amazonaws.com/calculator.apk");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        //address of appium server
        URL url = new URL("http://localhost:4723/wd/hub");
        AppiumDriver<MobileElement> driver = new AndroidDriver<>(url, desiredCapabilities);

        //explicit wait in appium works exactly in the same way as in Selenium
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.findElementById("com.google.android.calculator:id/digit_9").click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(MobileBy.AccessibilityId("plus")).click();
        driver.findElementById("com.google.android.calculator:id/digit_4").click();

        MobileElement equals = driver.findElement(MobileBy.AccessibilityId("equals"));
        equals.click();
        Thread.sleep(3000);

        MobileElement result = driver.findElementById("com.google.android.calculator:id/result_final");
        Assert.assertEquals("Result is incorrect!", "99", result.getText());

        driver.closeApp();
    }
}
