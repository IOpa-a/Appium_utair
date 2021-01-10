package steps;

import cucumber.api.java8.Ru;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import pages.BasePage;
import utils.Driver;


public class BaseStep extends Driver implements Ru {

    public BaseStep() {
        Если("^войти без авторизации$", () -> {
            for (int i = 0; i < 4; i++) {
                basePage.swipeScreen(BasePage.Direction.LEFT);
            }
            basePage.button("Начать").click();
            basePage.button("ПРОПУСТИТЬ").click();
        });

        И("^нажать кнопку \"([^\"]*)\"$", (String buttonName) -> {
            basePage.button(buttonName).click();
        });
        И("^заполнить поля:$", (DataTable data) -> data.asMap(String.class, String.class).forEach((field, value) -> {
            basePage.button((String) field).click();
            if (field.equals("Пол")) {
                passengerDataPage.genderVariants((String) value).click();

            } else if (field.equals("Дата рождения") || field.equals("Дата окончания")) {
                purchasePage.selectCalendarDate((String) value);
                purchasePage.buttonCalendar("ОК").click();

            } else if (field.equals("Документ") || field.equals("Страна")) {
                basePage.button((String) value).click();
                basePage.button("Выбрать").click();

            } else {
                basePage.field((String) field).sendKeys((CharSequence) value);
                basePage.button((String) value).click();
            }
        }));
        Тогда("^активен \"([^\"]*)\"$", (String step) -> {
            Assert.assertTrue("Шаг " + step + " не найден", basePage.isStepActive(step));
        });
        И("^поле \"([^\"]*)\" присутствует$", (String field) -> {
            Assert.assertTrue(basePage.fieldIsContent(field).isDisplayed());
        });
        И("^поле \"([^\"]*)\" заполнено значением \"([^\"]*)\"$", (String field, String value) -> {
            Assert.assertTrue("Поле " + field + " заполнено другим значением", basePage.fieldWithValue(field, value));
        });
        Тогда("^присутствует сообщение \"([^\"]*)\"$", (String message) -> {
            Assert.assertEquals("Сообщение '" + message + "' не найдено", basePage.messages().getText().replaceAll("\"", ""), message);
        });
        Тогда("^присутствует всплывающее окно \"([^\"]*)\"$", (String title) -> {
            Assert.assertEquals("Окно не найдено", basePage.modalTitle().getText(), title);
        });
        И("^очистить поле \"([^\"]*)\"$", (String field) -> {
            basePage.button((String) field).click();
            basePage.field(field).clear();
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        });
    }
}
