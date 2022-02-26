package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private static AppiumDriver<MobileElement> driver;

    private Driver(){}

    public static AppiumDriver<MobileElement> getDriver() {
        if(driver == null) {
            //AppiumDriver is a parent for AndroidDriver and IOSDriver
            //you can handle within 1 framework testing of ios and android
            //moreover, you can handle web, ios and android within 1 framework
            //therefore, getDriver must return something in common for all platforms (WebDriver)
            //of course it will require casting for mobile interactions, but it's doable
            //from this course, you've tried to cast driver for js execution and screenshot capturing
            //to improve this class, add switch statement (to switch in between IOS and Android)
            //read app path from configuration.properties file
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("platformVersion", "10.0");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
            //android apps have .apk extension
            //file can be stored locally or in a cloud storage
            desiredCapabilities.setCapability("app", "https://cybertek-appium.s3.amazonaws.com/calculator.apk");
            desiredCapabilities.setCapability("automationName", "UiAutomator2");
            //address of appium server
            URL url = null;
            try {
                url = new URL("http://localhost:4723/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            driver = new AndroidDriver<>(url, desiredCapabilities);
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.closeApp();
            driver = null;
        }
    }
}
