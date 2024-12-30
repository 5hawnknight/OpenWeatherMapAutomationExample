/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.emulation;

import org.themelios.core.locator.Locator;

import java.util.function.Function;

public interface EmulationAPI {
    Function<Locator,Locator> emulateMoveTo = locator -> {
        EmulationFunctions.emulateMoveToLocator.accept(locator);
        return locator;
    };
    Function<Locator, Locator> emulateClick = locator -> {
        EmulationFunctions.emulateClick.accept(locator);
        return locator;
    };
}