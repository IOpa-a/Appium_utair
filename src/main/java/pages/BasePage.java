package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BasePage {
    private AndroidDriver driver;
    private WebDriverWait wait;
    static Map<String, String> data = new HashMap<>();

    public BasePage() {
    }

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }

    public MobileElement button(String buttonName) {
        String xpath = "//*[@class='android.widget.TextView' and contains(@text,'" + buttonName + "')]|//*[contains(@class,'Button') and contains(@text,'" + buttonName + "')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        MobileElement element = (MobileElement) driver.findElementByXPath(xpath);
        return element;
    }

    public MobileElement field(String fieldName) {
        String xpath = "//*[@class='android.widget.EditText' and contains(@text,'" + fieldName + "')]|//*[contains(@text,'" + fieldName + "')]/../*[@class='android.widget.EditText']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        MobileElement element = (MobileElement) driver.findElementByXPath(xpath);
        return element;
    }

    public MobileElement fieldIsContent(String content) {
        String xpath = "//*[contains(@text,'" + content + "')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return (MobileElement) driver.findElementByXPath(xpath);
    }

    public boolean isStepActive(String step) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='" + step + "']")));
        return driver.findElement(By.xpath("//*[@text='" + step + "']")).isDisplayed();
    }

    public boolean fieldWithValue(String field ,String value){
        String xpath = "//*[@class='android.widget.TextView' and contains(@text,'" + field + "')]/../*[@class='android.widget.TextView' and contains(@text,'" + value + "')]";
        return  driver.findElementByXPath(xpath).isDisplayed();
    }
    public MobileElement messages(){
        String xpat = "//*[contains(@resource-id, 'android:id/message')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpat)));
        return (MobileElement)driver.findElementByXPath(xpat);
    }
    public MobileElement modalTitle(){
        String xpath = "//*[contains(@resource-id, 'ru.utair.android:id/alertTitle')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return (MobileElement)driver.findElementByXPath(xpath);
    }

    public void swipeScreen(Direction dir) {
        final int ANIMATION_TIME = 200;
        final int PRESS_TIME = 200;
        int edgeBorder = 10;

        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = driver.manage().window().getSize();
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN:
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP:
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT:
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT:
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException ignored) {
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
    public void scrollText(String text){
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(0));"));
    }
    public static void saveData(String key, String value) {
        data.put(key, value);
    }

    public static String getData(String key) {
        return data.get(key);
    }
}
