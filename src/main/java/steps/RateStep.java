package steps;

import cucumber.api.java8.Ru;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import utils.Driver;

import static pages.BasePage.saveData;


public class RateStep extends Driver implements Ru {

    public RateStep() {

        И("^присутствуют тарифы:$", (DataTable data) -> data.asList(String.class).forEach((rate) -> {
            Assert.assertTrue("Тариф " + rate + " не найден", ratePage.rateListName((String) rate));
        }));
        Тогда("^присутствуют опции:$", (DataTable data) -> data.asMap(String.class, String.class).forEach((name, value) -> {
            basePage.scrollText((String)name);
            Assert.assertEquals("Опция неверна: " + name, ratePage.serviceTitle((String) name, (String) value), value);
        }));
        И("^выбрать тариф \"([^\"]*)\"$", (String rate) -> {
            saveData("rateName", rate);
            basePage.button(rate).click();
        });
    }
}
