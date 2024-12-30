/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.themelios.handlers.DriverHandler;

import java.util.function.Function;

class Converter {

    protected static Locator toLocator(final WebElement element) {
        return LocatorBuilder.of(By.cssSelector(convertToCSS.apply(element)));
    }

    private static final Function<WebElement,String> convertToCSS = element ->
            (String) ((JavascriptExecutor) DriverHandler.driver()).executeScript("""
                 function cssPath(el) {
                     if (!(el instanceof Element))
                        return;
                     var path = [];
                     const prefixDataTag = "data-tea"
                     
                     while (el.nodeType === Node.ELEMENT_NODE) {
                        var selector = el.nodeName.toLowerCase();
                        var isDataTag = false;
                        var dataTagName = "";
                        
                        for (let name of el.getAttributeNames()) {
                            if (name.startsWith(prefixDataTag)) {
                                isDataTag = true;
                                dataTagName = name;
                                break;
                            }
                        }
                        if (isDataTag) {
                            var attribute = el.getAttribute(dataTagName);
                            selector = "[" + dataTagName + "='" + attribute + "']";
                            path.unshift(selector);
                            break;
                        }
                        else if (el.id) {
                             selector += "[id='" + el.id + "']";
                             path.unshift(selector);
                             break;
                        }
                        else if (el.hasAttribute("name")) {
                            var attribute = el.getAttribute("name");
                            selector += "[name='" + attribute + "']";
                            path.unshift(selector);
                            break;
                        }
                        else {
                            var sib = el, nth = 1;
                            while (sib = sib.previousElementSibling) {
                                if (sib.nodeName.toLowerCase() == selector)
                                    nth++;
                            }
                            if (nth != 1)
                                selector += ":nth-of-type("+nth+")";
                       }
                        path.unshift(selector);
                        el = el.parentNode;
                     }
                     return path.join(" > ");
                 }
                 return cssPath(arguments[0]);""", element);
}