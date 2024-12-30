package com.openweathermap.project.webdrivers;

import com.openweathermap.project.webdrivers.local.Chrome;
import com.openweathermap.project.webdrivers.local.Firefox;
import org.themelios.core.services.RegisterWebDrivers;
import org.themelios.core.services.WebDriverType;

import java.util.List;

public class RegisterLocalWebDrivers implements RegisterWebDrivers {
    @Override
    public List<WebDriverType> getTypes() {
        return List.of(new Firefox(),new Chrome());
    }
}
