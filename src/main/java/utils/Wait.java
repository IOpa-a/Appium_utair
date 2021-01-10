package utils;

import java.util.function.Supplier;

import static java.lang.Thread.sleep;

public class Wait {

    public static void sec(int seconds) {
        try {
            sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
