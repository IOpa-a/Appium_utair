package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PassengerDataPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public PassengerDataPage() {
    }

    public PassengerDataPage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }

    public MobileElement genderVariants(String gender) {
        if (gender.equals("Мужской")) {
            return (MobileElement) driver.findElement(By.xpath("//*[@text='Пол']"));
        } else
            return (MobileElement) driver.findElement(By.xpath("(//android.view.View)[5]"));
    }

    public boolean BlockIsDisplay(String block) {
        return driver.findElement(By.xpath("//*[contains(@resource-id, 'ru.utair.android:id/passengerType')]/../*[@text='" + block + "']")).isDisplayed();
    }
}
