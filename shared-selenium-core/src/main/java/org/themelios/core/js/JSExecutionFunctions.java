/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.js;

import org.apache.commons.lang3.BooleanUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.themelios.handlers.DriverHandler;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

interface JSExecutionFunctions {
    Supplier<JavascriptExecutor> jsExecutor = () -> (JavascriptExecutor) DriverHandler.driver();

    Consumer<WebElement> scrollIntoViewAtTop = element ->
            jsExecutor.get().executeScript("arguments[0].scrollIntoView(true);",element);

    Consumer<WebElement> scrollIntoViewAtBottom = element ->
            jsExecutor.get().executeScript("arguments[0].scrollIntoView(false);",element);

    Function<WebElement,Boolean> isInViewport = element -> {
        String isInViewportScript = "function isInViewport(element) { var rect = element.getBoundingClientRect(); var html = document.documentElement; return ( rect.top >= 0 && rect.left >= 0 && rect.bottom <= (window.innerHeight || html.clientHeight) && rect.right <= (window.innerWidth || html.clientWidth) ); }; return isInViewport(arguments[0])";
        return BooleanUtils.toBoolean(jsExecutor.get().executeScript(isInViewportScript,element).toString());
    };

    Consumer<WebElement> jsClick = element -> jsExecutor.get().executeScript( "arguments[0].click();",element);
}
