/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.emulation;

import org.openqa.selenium.interactions.Actions;
import org.themelios.core.locator.Locator;

import java.util.function.Consumer;

import static org.themelios.handlers.DriverHandler.*;

interface EmulationFunctions {
    Consumer<Locator> emulateMoveToLocator = element -> new Actions(driver()).moveToElement(element.element()).build().perform();
    Consumer<Locator> emulateClick = element -> new Actions(driver()).click(element.element()).perform();
}