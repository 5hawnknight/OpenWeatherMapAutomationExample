/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.themelios.handlers.DriverHandler.driver;

public interface Locator {

    By selector();

    default WebElement element() {
        return driver().findElement(selector());
    }

    default List<WebElement> elements() {
        return driver().findElements(selector());
    }

    default List<Locator> locators() {
        return driver().findElements(selector()).stream()
                .map(element -> Converter.toLocator(element)).collect(Collectors.toList());
    }

    default Locator chain(Locator child) {
        return LocatorBuilder.chained(this,child);
    }

    default Locator chain(Function<String, Locator> function, String value) {
        return LocatorBuilder.chained(this, function.apply(value));
    }
}

record LocatorBuilder() {

    public static Locator of(By by) {
        return () -> by;
    }
    public static Locator chained(Locator parent, Locator child) {
        return () -> new ByChained(parent.selector(), child.selector());
    }
}
