/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022-2022.
 */

package org.themelios.core.locator;

import org.themelios.models.Dimension;
import org.themelios.models.Point;
import org.themelios.models.Rectangle;
import org.themelios.models.ShadowRoot;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static org.themelios.core.utilities.UtilitiesAPI.ignoreExceptions;

public interface LocatorAPI {

    UnaryOperator<Locator> click = locator -> {
        LocatorFunctions.click.accept(locator);
        return locator;
    };

    UnaryOperator<Locator> clear = locator -> {
        LocatorFunctions.clear.accept(locator);
        return locator;
    };

    Function<CharSequence, Function<Locator, Locator>> typeText = value -> locator -> {
        LocatorFunctions.typeText.apply(value).accept(locator);
        return locator;
    };

    static Function<Locator, Locator> typeText(final CharSequence value) {
        return locator -> {
            LocatorFunctions.typeText.apply(value).accept(locator);
            return locator;
        };
    }

    Function<Locator, Locator> submit = locator -> {
        LocatorFunctions.submit.accept(locator);
        return locator;
    };

    Function<Locator, String> getText = locator -> LocatorFunctions.getText.apply(locator);
    Function<Locator, String> getValue = locator -> LocatorFunctions.getValue.apply( locator);

    Function<String, Function<Locator, String>> getAttribute = value -> locator -> LocatorFunctions.getAttribute.apply(value).apply(locator);

    static Function<Locator, String> getAttribute(final String value) {
        return locator -> LocatorFunctions.getAttribute.apply(value).apply(locator);
    }

    Function<String, Function<Locator, String>> getCssValue = value -> locator -> LocatorFunctions.getCssValue.apply(value).apply(locator);

    static Function<Locator, String> getCssValue(final String value) {
        return locator -> LocatorFunctions.getCssValue.apply(value).apply(locator);
    }

    Function<Locator, Point> getLocation = locator -> LocatorFunctions.getLocation.apply(locator);
    Function<Locator, Rectangle> getRect = locator -> LocatorFunctions.getRect.apply(locator);
    Function<Locator, Dimension> getSize = locator -> LocatorFunctions.getSize.apply(locator);
    Function<Locator, String> getTagName = locator -> LocatorFunctions.getTagName.apply(locator);

    Function<Locator, String> getAccessibleName = locator -> LocatorFunctions.getAccessibleName.apply(locator);
    Function<Locator, String> getAriaRole = locator -> LocatorFunctions.getAriaRole.apply(locator);

    Function<String, Function<Locator, String>> getDomAttribute = value -> locator -> LocatorFunctions.getDomAttribute.apply(value).apply(locator);
    Function<String, Function<Locator, String>> getDomProperty = value -> locator -> LocatorFunctions.getDomProperty.apply(value).apply(locator);
    Function<Locator, ShadowRoot> getShadowRoot = locator -> LocatorFunctions.getShadowRoot.apply(locator);

    Function<Locator, Boolean> isDisplayed = locator -> ignoreExceptions.apply(LocatorFunctions.isDisplayed).apply(locator);
    Function<Locator, Boolean> isEnabled = locator -> ignoreExceptions.apply(LocatorFunctions.isEnabled).apply(locator);
    Function<Locator, Boolean> isSelected = locator -> ignoreExceptions.apply(LocatorFunctions.isSelected).apply(locator);

    Function<Integer, Function<Locator, Locator>> selectByIndex = index -> locator -> {
        LocatorFunctions.selectByIndex.apply(index).accept(locator);
        return locator;
    };

    static Function<Locator, Locator> selectByIndex(final Integer index) {
        return locator -> {
            LocatorFunctions.selectByIndex.apply(index).accept(locator);
            return locator;
        };
    }

    Function<String, Function<Locator, Locator>> selectByValue = value -> locator -> {
        LocatorFunctions.selectByValue.apply(value).accept(locator);
        return locator;
    };

    static Function<Locator, Locator> selectByValue(final String value) {
        return locator -> {
            LocatorFunctions.selectByValue.apply(value).accept(locator);
            return locator;
        };
    }

    Function<String, Function<Locator, Locator>> selectByVisibleText = text -> locator -> {
        LocatorFunctions.selectByVisibleText.apply(text).accept(locator);
        return locator;
    };

    static Function<Locator, Locator> selectByVisibleText(final String text) {
        return locator -> {
            LocatorFunctions.selectByVisibleText.apply(text).accept(locator);
            return locator;
        };
    }

    Function<Integer, Function<Locator, Locator>> deselectByIndex = index -> locator -> {
        LocatorFunctions.deselectByIndex.apply(index).accept(locator);
        return locator;
    };

    static Function<Locator, Locator> deselectByIndex(final Integer index) {
        return locator -> {
            LocatorFunctions.deselectByIndex.apply(index).accept(locator);
            return locator;
        };
    }

    Function<String, Function<Locator, Locator>> deselectByValue = value -> locator -> {
        LocatorFunctions.deselectByValue.apply(value).accept(locator);
        return locator;
    };

    static Function<Locator, Locator> deselectByValue(final String value) {
        return locator -> {
            LocatorFunctions.deselectByValue.apply(value).accept(locator);
            return locator;
        };
    }

    Function<String, Function<Locator, Locator>> deselectByVisibleText = text -> locator -> {
        LocatorFunctions.deselectByVisibleText.apply(text).accept(locator);
        return locator;
    };

    static Function<Locator, Locator> deselectByVisibleText(final String text) {
        return locator -> {
            LocatorFunctions.deselectByVisibleText.apply(text).accept(locator);
            return locator;
        };
    }

    Function<Locator, Boolean> selectIsMultiple = locator -> LocatorFunctions.selectIsMultiple.apply(locator);
    Function<Locator, List<Locator>> selectGetOptions = locator -> LocatorFunctions.selectGetOptions.apply(locator);
    Function<Locator, List<Locator>> selectGetAllSelectedOptions = locator -> LocatorFunctions.selectGetAllSelectedOptions.apply(locator);
    Function<Locator, Locator> selectGetFirstSelectedOption = locator -> LocatorFunctions.selectGetFirstSelectedOption.apply(locator);
}
