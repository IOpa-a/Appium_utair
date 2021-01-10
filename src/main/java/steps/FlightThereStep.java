package steps;

import io.cucumber.java8.Ru;
import org.junit.Assert;
import utils.Driver;

public class FlightThereStep extends Driver implements Ru {

    public FlightThereStep() {

        Если("^присутствуют рейсы$", () -> {
            Assert.assertTrue("Рейсы не найдены",flightTherePage.flightIsDisplay());
        });
        И("^выбрать (\\d+) рейс в списке$", (Integer num) -> {
            flightTherePage.flight(num).click();
        });


    }
}
