package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    public static AndroidDriver<MobileElement> driver;
    public static BasePage basePage;
    public static PurchasePage purchasePage;
    public static FlightTherePage flightTherePage;
    public static RatePage ratePage;
    public static PassengerDataPage passengerDataPage;

    public static void Android_LaunchApp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "fek79l7934345huvs");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        cap.setCapability("appPackage", "ru.utair.android");
        cap.setCapability("appActivity", "ru.appkode.utair.ui.main.MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        basePage = new BasePage(driver);
        purchasePage = new PurchasePage(driver);
        flightTherePage = new FlightTherePage(driver);
        ratePage = new RatePage(driver);
        passengerDataPage = new PassengerDataPage(driver);
    }

    public static void closeApp() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}