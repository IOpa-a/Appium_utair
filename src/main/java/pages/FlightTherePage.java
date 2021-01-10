package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class FlightTherePage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public FlightTherePage() {
    }

    public FlightTherePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }
    public MobileElement flight(int num) {
        List <MobileElement> flightList = new ArrayList<>();
        String xpath = "//*[contains(@resource-id, 'ru.utair.android:id/recyclerView')]/*[contains(@class, 'android.view.ViewGroup')]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        flightList.add((MobileElement)driver.findElement(By.xpath(xpath)));
        return flightList.get(--num);
    }
    public Boolean flightIsDisplay(){
        String xpath = "//*[contains(@resource-id, 'ru.utair.android:id/recyclerView')]/*[contains(@class, 'android.view.ViewGroup')]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

}
