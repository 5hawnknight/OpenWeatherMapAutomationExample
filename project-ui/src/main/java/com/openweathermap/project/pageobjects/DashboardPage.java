package com.openweathermap.project.pageobjects;

import com.openweathermap.project.models.City;
import org.themelios.core.LoadablePageObject;
import org.themelios.core.locator.Locator;

import java.util.function.Function;
import java.util.function.Supplier;

public interface DashboardPage {
    Supplier<DashboardPage> po = () -> {
        class Instance implements DashboardPage, LoadablePageObject<DashboardPage> {

            private final Locator container = id.apply("button-container");
            private final Function<String,Locator> locationButton = value ->
                    css.apply(String.format("[data-tea-city-weather-button='%s']",value.toLowerCase()));

            /*
                Normally I would create another page object for the results table/row;
                however, I chose to forgo due to the simplicity of the application.
             */
            private final Locator resultsTable = css.apply("[data-tea-results-table]");
            private final Locator cityRow = resultsTable.chain(css.apply("[data-tea-row='city']"));

            @Override
            public void pageObjectInitializer() {
                toBeClickable.apply(container);
            }

            @Override
            public DashboardPage selectWeatherFor(City city) {
                click.apply(locationButton.apply(city.value()));
                toBeVisible.apply(resultsTable);
                return this;
            }

            @Override
            public Boolean isCityInResults(City city) {
                var value = getText.apply(cityRow);
                return city.value().equalsIgnoreCase(value);
            }
        }
        return new Instance().get();
    };
    DashboardPage selectWeatherFor(City city);
    Boolean isCityInResults(City city);
}


