/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.driver;

import org.themelios.core.locator.Locator;
import org.themelios.models.Cookies;
import org.themelios.models.Dimension;
import org.themelios.models.Point;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface DriverAPI {

    Supplier<String> sessionId = () -> DriverSession.getSessionId.get();
    Supplier<Cookies> cookies = () -> DriverFunctions.getCookies.get();
    Runnable quit = () -> DriverFunctions.quit.run();

    Runnable toDefaultContent = () -> DriverFunctions.toDefaultContent.run();
    Consumer<Locator> toFrame = locator -> DriverFunctions.toFrame.accept(locator);

    Supplier<String> getBrowserType = () -> BrowserTypeFunctions.getBrowserType.get();
    Supplier<Boolean> isBrowserFirefox = () -> BrowserTypeFunctions.isFirefox.get();
    Supplier<Boolean> isBrowserChrome = () -> BrowserTypeFunctions.isChrome.get();
    Supplier<Boolean> isBrowserEdge = () -> BrowserTypeFunctions.isEdge.get();
    Supplier<Boolean> isBrowserIE = () -> BrowserTypeFunctions.isIE.get();
    Supplier<Boolean> isBrowserSafari = () -> BrowserTypeFunctions.isSafari.get();
    Supplier<Boolean> isBrowserMobile = () -> BrowserTypeFunctions.isMobile.get();

    Runnable maximize = () -> DriverFunctions.maximize.run();
    Runnable fullscreen = () -> DriverFunctions.fullscreen.run();
    Runnable minimize = () -> DriverFunctions.minimize.run();
    Consumer<Dimension> setSize = dimension -> DriverFunctions.setSize.accept(dimension);
    Consumer<Point> setPosition = point -> DriverFunctions.setPosition.accept(point);
    Supplier<Point> getPosition = () -> DriverFunctions.getPosition.get();
    Supplier<Dimension> getSize = () -> DriverFunctions.getSize.get();
}



