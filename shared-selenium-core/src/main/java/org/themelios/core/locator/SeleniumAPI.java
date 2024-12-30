/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022-2022.
 */

package org.themelios.core.locator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

interface SeleniumAPI {
    Consumer<WebElement> clear = WebElement::clear;
    Consumer<WebElement> click = WebElement::click;
    BiConsumer<WebElement,CharSequence> sendKeys = WebElement::sendKeys;
    Consumer<WebElement> submit = WebElement::submit;
    Function<WebElement,String> getAccessibleName = WebElement::getAccessibleName;
    Function<WebElement,String> getAriaRole = WebElement::getAriaRole;
    BiFunction<String,WebElement,String> getAttribute = (value,element) -> element.getAttribute(value);
    BiFunction<String,WebElement,String> getCssValue = (value,element) -> element.getCssValue(value);
    BiFunction<String,WebElement,String> getDomAttribute = (value, element) -> element.getDomAttribute(value);
    BiFunction<String,WebElement,String> getDomProperty = (value, element) -> element.getDomProperty(value);
    Function<WebElement, Point> getLocation = WebElement::getLocation;
    Function<WebElement, Rectangle> getRect = WebElement::getRect;
    Function<WebElement, SearchContext> getShadowRoot = WebElement::getShadowRoot;
    Function<WebElement, Dimension> getSize = WebElement::getSize;
    Function<WebElement,String> getTagName = WebElement::getTagName;
    Function<WebElement,String> getText = WebElement::getText;
    Function<WebElement,Boolean> isDisplayed = WebElement::isDisplayed;
    Function<WebElement,Boolean> isEnabled = WebElement::isEnabled;
    Function<WebElement,Boolean> isSelected = WebElement::isSelected;
    Function<WebElement,Consumer<Integer>> selectByIndex = element -> index -> new Select(element).selectByIndex(index);
    Function<WebElement,Consumer<String>> selectByValue = element -> value -> new Select(element).selectByValue(value);
    Function<WebElement,Consumer<String>> selectByVisibleText = element -> text -> new Select(element).selectByVisibleText(text);
    Function<WebElement,Consumer<Integer>> deselectByIndex = element -> index -> new Select(element).deselectByIndex(index);
    Function<WebElement,Consumer<String>> deselectByValue = element -> value -> new Select(element).deselectByValue(value);
    Function<WebElement, Consumer<String>> deselectByVisibleText = element -> text -> new Select(element).deselectByVisibleText(text);
    Function<WebElement,Boolean> selectIsMultiple = element -> new Select(element).isMultiple();
    Function<WebElement, List<WebElement>> selectGetOptions = element -> new Select(element).getOptions().stream().toList();
    Function<WebElement,List<WebElement>> selectGetAllSelectedOptions = element -> new Select(element).getAllSelectedOptions().stream().toList();
    Function<WebElement,WebElement> selectGetFirstSelectedOption = element -> new Select(element).getFirstSelectedOption();
}