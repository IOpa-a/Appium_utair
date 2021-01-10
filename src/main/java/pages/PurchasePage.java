package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchasePage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public PurchasePage() {
    }

    public PurchasePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }

    public MobileElement firstCity() {
        MobileElement nameFirstCity = (MobileElement) driver.findElement(By.xpath("//*[contains(@resource-id, 'ru.utair.android:id/city_selector_title')]"));
        return nameFirstCity;
    }

    public MobileElement lastCity() {
        MobileElement nameLastCity = (MobileElement) driver.findElement(By.xpath("(//*[contains(@resource-id, 'ru.utair.android:id/city_selector_title')])[last()]"));
        return nameLastCity;
    }

    public MobileElement cityNameButton(String cityName) {
        return (MobileElement) driver.findElement(By.xpath("//*[contains(@resource-id, 'ru.utair.android:id/cityName') and @text='" + cityName + "']"));
    }

    public MobileElement selectCalendarDate(String date) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@content-desc,'" + date + "')]")));
        return (MobileElement) driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'" + date + "')]"));
    }

    public MobileElement buttonCalendar(String nameButton) {
        if (nameButton.equals("ОК"))
            return (MobileElement) driver.findElement(By.xpath("//*[contains(@resource-id, 'ru.utair.android:id/mdtp_ok')]"));
        else if (nameButton.equals("ОТМЕНА"))
            return (MobileElement) driver.findElement(By.xpath("//*[contains(@resource-id, 'ru.utair.android:id/mdtp_cancel')]"));
        else
            throw new ElementNotVisibleException("Кнопка не найдена");
    }

    public MobileElement buttonCalendarIsSelected() {
        return (MobileElement) driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'Выбран элемент')]"));
    }

    public MobileElement buttonCountPassPlus(String type) {
        switch (type) {
            case "Взрослый":
            case "Взрослых":
                return (MobileElement) driver.findElement(By.xpath("//*[contains(@resource-id, 'ru.utair.android:id/passenger_count_picker_button_inc_adults')]"));
            case "2-12 лет":
                return (MobileElement) driver.findElement(By.xpath("//*[contains(@resource-id, 'ru.utair.android:id/passenger_count_picker_button_inc_children')]"));
            case "до 2-х лет":
                return (MobileElement) driver.findElement(By.xpath("//*[contains(@resource-id, 'ru.utair.android:id/passenger_count_picker_button_inc_infants')]"));
            default:
                throw new ElementNotVisibleException("Кнопка " + type + " не найдена");
        }
    }

    public MobileElement buttonCountPassMinus(String type) {
        switch (type) {
            case "Взрослый":
            case "Взрослых":
                return (MobileElement) driver.findElement(By.xpath("//*[contains(@resource-id, 'ru.utair.android:id/passenger_count_picker_button_dec_adults')]"));
            case "2-12 лет":
                return (MobileElement) driver.findElement(By.xpath("//*[contains(@resource-id, 'ru.utair.android:id/passenger_count_picker_button_dec_children')]"));
            case "до 2-х лет":
                return (MobileElement) driver.findElement(By.xpath("//*[contains(@resource-id, 'ru.utair.android:id/passenger_count_picker_button_dec_infants')]"));
            default:
                throw new ElementNotVisibleException("Кнопка " + type + " не найдена");
        }
    }

    public MobileElement countSelectPass(String type) {
        switch (type) {
            case "Взрослый":
            case "Взрослых":
                return (MobileElement) driver.findElement(By.xpath("//*[contains(@resource-id, 'ru.utair.android:id/passenger_count_picker_adult_count')]"));
            case "2-12 лет":
                return (MobileElement) driver.findElement(By.xpath("//*[contains(@resource-id, 'ru.utair.android:id/passenger_count_picker_children_count')]"));
            case "до 2-х лет":
                return (MobileElement) driver.findElement(By.xpath("//*[contains(@resource-id, 'ru.utair.android:id/passenger_count_picker_infant_count')]"));
            default:
                throw new ElementNotVisibleException("Кнопка " + type + " не найдена");
        }
    }
}
