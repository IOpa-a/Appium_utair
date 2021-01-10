package steps;

import io.cucumber.java8.Ru;
import org.junit.Assert;
import utils.Driver;

public class PassengerDataStep extends Driver implements Ru {

    public PassengerDataStep() {
        Тогда("^блок \"([^\"]*)\" присутствует$", (String block) -> {
            Assert.assertTrue("Блок " + block + " не найден", passengerDataPage.BlockIsDisplay(block));
        });
        Тогда("^(\\d+) блок \"([^\"]*)\" присутствует$", (Integer arg0, String arg1) -> {
        });
    }
}