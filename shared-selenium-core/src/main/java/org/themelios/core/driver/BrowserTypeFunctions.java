/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.driver;

import java.util.Optional;
import java.util.function.Supplier;

interface BrowserTypeFunctions {
    Supplier<String> getBrowserType = () -> Optional.ofNullable(DriverCapabilities.getCapabilities.get().getBrowserName()).orElse("unknown");
    Supplier<Boolean> isFirefox = () -> "firefox".equalsIgnoreCase(getBrowserType.get());
    Supplier<Boolean> isChrome = () -> "chrome".equalsIgnoreCase(getBrowserType.get());
    Supplier<Boolean> isEdge = () -> "MicrosoftEdge".equalsIgnoreCase(getBrowserType.get());
    Supplier<Boolean> isIE = () -> "internet explorer".equalsIgnoreCase(getBrowserType.get());
    Supplier<Boolean> isSafari = () -> "safari".equalsIgnoreCase(getBrowserType.get());
    Supplier<Boolean> isMobile = () -> DriverCapabilities.getCapabilities.get().asMap().containsKey("deviceName");
}