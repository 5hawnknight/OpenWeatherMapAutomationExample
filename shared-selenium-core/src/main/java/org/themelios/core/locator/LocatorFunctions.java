/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.locator;

import org.themelios.core.utilities.Converter;
import org.themelios.models.Dimension;
import org.themelios.models.Point;
import org.themelios.models.Rectangle;
import org.themelios.models.ShadowRoot;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface LocatorFunctions {

    Consumer<Locator> click = locator -> SeleniumAPI.click.accept(locator.element());
    Consumer<Locator> clear = locator -> SeleniumAPI.clear.accept(locator.element());
    Function<CharSequence, Consumer<Locator>> typeText = value -> locator -> SeleniumAPI.sendKeys.accept(locator.element(), value);
    Consumer<Locator> submit = locator -> SeleniumAPI.submit.accept(locator.element());
    Function<Locator, String> getText = locator -> SeleniumAPI.getText.apply(locator.element());
    Function<Locator, String> getValue = locator -> SeleniumAPI.getAttribute.apply("value", locator.element());

    Function<String, Function<Locator, String>> getAttribute = value -> locator -> SeleniumAPI.getAttribute.apply(value, locator.element());
    Function<String, Function<Locator, String>> getCssValue = value -> locator -> SeleniumAPI.getCssValue.apply(value, locator.element());

    Function<Locator, Point> getLocation = locator -> Converter.toPoint.apply(SeleniumAPI.getLocation.apply(locator.element()));
    Function<Locator, Rectangle> getRect = locator -> Converter.toRectangle.apply(SeleniumAPI.getRect.apply(locator.element()));
    Function<Locator, Dimension> getSize = locator -> Converter.toDimension.apply(SeleniumAPI.getSize.apply(locator.element()));
    Function<Locator, String> getTagName = locator -> SeleniumAPI.getTagName.apply(locator.element());

    Function<Locator, String> getAccessibleName = locator -> SeleniumAPI.getAccessibleName.apply(locator.element());
    Function<Locator, String> getAriaRole = locator -> SeleniumAPI.getAriaRole.apply(locator.element());

    Function<String, Function<Locator, String>> getDomAttribute = value -> locator -> SeleniumAPI.getDomAttribute.apply(value, locator.element());
    Function<String, Function<Locator, String>> getDomProperty = value -> locator -> SeleniumAPI.getDomProperty.apply(value, locator.element());
    Function<Locator, ShadowRoot> getShadowRoot = locator -> Converter.toShadowRoot.apply(SeleniumAPI.getShadowRoot.apply(locator.element()));

    Function<Locator, Boolean> isDisplayed = locator -> SeleniumAPI.isDisplayed.apply(locator.element());
    Function<Locator, Boolean> isEnabled = locator -> SeleniumAPI.isEnabled.apply(locator.element());
    Function<Locator, Boolean> isSelected = locator -> SeleniumAPI.isSelected.apply(locator.element());

    Function<Integer, Consumer<Locator>> selectByIndex = index -> locator -> SeleniumAPI.selectByIndex.apply(locator.element()).accept(index);
    Function<String, Consumer<Locator>> selectByValue = value -> locator -> SeleniumAPI.selectByValue.apply(locator.element()).accept(value);

    Function<String, Consumer<Locator>> selectByVisibleText = text -> locator -> SeleniumAPI.selectByVisibleText.apply(locator.element()).accept(text);
    Function<Integer, Consumer<Locator>> deselectByIndex = index -> locator -> SeleniumAPI.deselectByIndex.apply(locator.element()).accept(index);
    Function<String, Consumer<Locator>> deselectByValue = value -> locator -> SeleniumAPI.deselectByValue.apply(locator.element()).accept(value);
    Function<String, Consumer<Locator>> deselectByVisibleText = text -> locator -> SeleniumAPI.deselectByVisibleText.apply(locator.element()).accept(text);

    Function<Locator, Boolean> selectIsMultiple = locator -> SeleniumAPI.selectIsMultiple.apply(locator.element());
    Function<Locator, List<Locator>> selectGetOptions = locator -> SeleniumAPI.selectGetOptions.apply(locator.element()).stream().map(e -> org.themelios.core.locator.Converter.toLocator(e)).collect(Collectors.toList());
    Function<Locator, List<Locator>> selectGetAllSelectedOptions = locator -> SeleniumAPI.selectGetAllSelectedOptions.apply(locator.element()).stream().map(e -> org.themelios.core.locator.Converter.toLocator(e)).collect(Collectors.toList());
    Function<Locator, Locator> selectGetFirstSelectedOption = locator -> org.themelios.core.locator.Converter.toLocator(SeleniumAPI.selectGetFirstSelectedOption.apply(locator.element()));
}
