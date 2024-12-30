/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.locator;

@FunctionalInterface
public interface MultiLocatorFunction<R>   {
    R apply(Locator...locators);
}
