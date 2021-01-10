package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.BasePage.getData;

public class RatePage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public RatePage() {
    }

    public RatePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }

    public boolean rateListName(String nameTitle) {
        return driver.findElement(By.xpath("//*[contains(@resource-id,'ru.utair.android:id/tariffTitle') and @text='" + nameTitle + "']")).isDisplayed();
    }

    public String serviceTitle(String nameTitle, String value) {
        String xpathTextValue = "//*[@text='" + getData("rateName") + "']/..//*[contains(@resource-id,'ru.utair.android:id/serviceTitle') and @text='" + nameTitle + "']/../*[contains(@resource-id,'ru.utair.android:id/serviceValue')]";
        String xpathEnableValue = "//*[@text='" + getData("rateName") + "']/..//*[contains(@resource-id,'ru.utair.android:id/serviceTitle') and @text='" + nameTitle + "']";
        if (value.equals("+")) {
            if (driver.findElement(By.xpath(xpathEnableValue)).getAttribute("enabled").equals("true"))
                return "+";
            else return "-";
        } else {
            return driver.findElement(By.xpath(xpathTextValue)).getText().trim();
        }
    }
}