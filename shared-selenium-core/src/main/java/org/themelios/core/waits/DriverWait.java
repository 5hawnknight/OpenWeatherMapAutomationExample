package org.themelios.core.waits;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.themelios.core.time.Interval;
import org.themelios.handlers.DriverHandler;

import java.util.function.Function;

interface DriverWait {
    Function<Interval,WebDriverWait> getWait = time -> new WebDriverWait(DriverHandler.driver(), Interval.of(time));

    static WebDriverWait getWait(final Interval interval) {
        return new WebDriverWait(DriverHandler.driver(), Interval.of(interval));
    }
}
