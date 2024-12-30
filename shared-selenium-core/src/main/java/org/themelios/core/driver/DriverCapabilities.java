/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.themelios.handlers.DriverHandler;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

interface DriverCapabilities {

    Supplier<Capabilities> remoteCapabilities = () -> ((RemoteWebDriver) DriverHandler.driver()).getCapabilities();

    Function<Supplier<Capabilities>,Optional<Capabilities>> tryCapabilities = supplier -> {
        try { return Optional.of(supplier.get()); }
        catch (ClassCastException e) { return Optional.empty(); }
    };

    Supplier<Capabilities> getCapabilities = () ->
            tryCapabilities.apply(remoteCapabilities)
                    .orElse(new DesiredCapabilities());
}