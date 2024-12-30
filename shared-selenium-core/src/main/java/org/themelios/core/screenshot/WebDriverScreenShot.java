/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.screenshot;

import org.openqa.selenium.WebDriver;
import org.themelios.handlers.DriverHandler;

import java.util.function.BiConsumer;

interface WebDriverScreenShot {
    BiConsumer<String, BiConsumer<WebDriver,String>> take = (fileName, function) ->
            function.accept(DriverHandler.driver(), fileName);
}