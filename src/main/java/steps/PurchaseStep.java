package steps;

import cucumber.api.java8.Ru;
import org.junit.Assert;
import utils.Driver;

public class PurchaseStep extends Driver implements Ru {


    public PurchaseStep() {
        Тогда("^город вылета \"([^\"]*)\" выбран$", (String city) -> {
            Assert.assertEquals("Город вылета " + city + "не найден", purchasePage.firstCity().getText(), city);
        });
        Тогда("^город прилета \"([^\"]*)\" выбран$", (String city) -> {
            Assert.assertEquals("Город прилета " + city + "не найден",purchasePage.lastCity().getText(), city);
        });
        И("^выбрать город \"([^\"]*)\"$", (String city) -> {
            purchasePage.cityNameButton(city).click();
        });
        Тогда("^конец теста$", () -> {
        });
        И("^выбрать дату \"([^\"]*)\"$", (String date) -> {
            purchasePage.selectCalendarDate(date).click();
        });
        Тогда("^дата выбрана \"([^\"]*)\"$", (String content) -> {
            Assert.assertTrue("Выбрана другая дата",basePage.fieldIsContent(content).isDisplayed());
        });
        И("^добавить (\\d+) билет\\(а\\), тип \"([^\"]*)\"$", (Integer num, String type) -> {
            for (int i = 0; i < num; i++) {
                purchasePage.buttonCountPassPlus(type).click();
            }
        });
        И("^удалить (\\d+) билет\\(а\\), тип \"([^\"]*)\"$", (Integer num, String type) -> {
            for (int i = 0; i < num; i++) {
                purchasePage.buttonCountPassMinus(type).click();
            }
        });
        Тогда("^выбрано (\\d+) билет\\(а\\), тип \"([^\"]*)\"$", (Integer count, String type) -> {
            Assert.assertEquals("Билеты не найдены",purchasePage.countSelectPass(type).getText(), String.valueOf(count));
        });
        Тогда("^дата \"([^\"]*)\" не доступна$", (String date) -> {
            Assert.assertNotEquals(purchasePage.buttonCalendarIsSelected().getAttribute("content-desc"), "Выбран элемент " + date);
        });


    }
}
