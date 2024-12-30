/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.driver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.themelios.handlers.DriverHandler;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

interface DriverSession {

    Supplier<String> remoteSessionId = () ->
        Optional.ofNullable(DriverHandler.driver())
                .map(d -> (((RemoteWebDriver) d).getSessionId()))
                .filter(Objects::nonNull)
                .map(s -> s.toString()).orElse("");

    Function<Supplier<String>,Optional<String>> trySessionId = supplier -> {
        try { return Optional.of(supplier.get()); }
        catch (ClassCastException e) { return Optional.empty(); }
    };

    Supplier<String> getSessionId = () -> trySessionId.apply(remoteSessionId).orElse("there is not an id for this session");
}