/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.js;

import org.themelios.core.locator.Locator;

import java.util.function.Function;

public interface JSExecutionAPI {

    Function<Locator,Locator> jsScrollIntoViewAtTop = locator -> {
        JSExecutionFunctions.scrollIntoViewAtTop.accept(locator.element()); return locator;
    };

    Function<Locator,Locator> jsScrollIntoViewAtBottom = locator -> {
        JSExecutionFunctions.scrollIntoViewAtBottom.accept(locator.element()); return locator;
    };

    Function<Locator,Boolean> jsIsInViewport = locator -> JSExecutionFunctions.isInViewport.apply(locator.element());

    Function<Locator,Locator> jsClick = locator -> {
        JSExecutionFunctions.jsClick.accept(locator.element()); return locator;
    };
}