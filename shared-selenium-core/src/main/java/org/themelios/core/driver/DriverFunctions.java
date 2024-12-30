/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.driver;

import org.themelios.core.locator.Locator;
import org.themelios.core.utilities.Converter;
import org.themelios.models.Cookies;
import org.themelios.models.Dimension;
import org.themelios.models.Point;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.themelios.handlers.DriverHandler.driver;

interface DriverFunctions {

    Runnable toDefaultContent = () -> driver().switchTo().defaultContent();
    Consumer<Locator> toFrame = locator -> driver().switchTo().frame(locator.element());

    Runnable quit = () -> driver().quit();

    Supplier<Cookies> getCookies = () -> Converter.toCookies.apply(driver().manage().getCookies());

    Runnable maximize = () -> driver().manage().window().maximize();
    Runnable fullscreen = () -> driver().manage().window().fullscreen();
    Runnable minimize = () -> driver().manage().window().minimize();
    Consumer<Dimension> setSize = dimension -> driver().manage().window().setSize(Converter.revert(dimension));
    Consumer<Point> setPosition = point -> driver().manage().window().setSize(Converter.revert(point));
    Supplier<Point> getPosition = () -> Converter.toPoint.apply(driver().manage().window().getPosition());
    Supplier<Dimension> getSize = () -> Converter.toDimension.apply(driver().manage().window().getSize());
}