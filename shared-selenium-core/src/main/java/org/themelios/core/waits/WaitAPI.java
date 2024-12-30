/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.waits;

import org.themelios.core.locator.Locator;
import org.themelios.core.locator.MultiLocatorFunction;
import org.themelios.core.time.Interval;
import org.themelios.models.Attribute;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public interface WaitAPI {

    UnaryOperator<Locator> toBeClickable = locator -> {
       WaitFunctions.waitForToBeClickable.accept(locator);
       return locator;
    };

    Function<Interval, UnaryOperator<Locator>> toBeClickableWithInDuration = time -> locator -> {
        WaitFunctions.waitForToBeClickableWithInDuration.apply(time).accept(locator);
        return locator;
    };

    MultiLocatorFunction<List<Locator>> eachToBeClickable = locators -> {
        Arrays.stream(locators).forEach(locator -> WaitFunctions.waitForToBeClickable.accept(locator));
        return List.of(locators);
    };

    UnaryOperator<Locator> toBeVisible = locator -> {
        WaitFunctions.waitForToBeVisible.accept(locator);
        return locator;
    };

    Function<Interval, UnaryOperator<Locator>> toBeVisibleWithInDuration = time -> locator -> {
        WaitFunctions.waitForToBeVisibleWithInDuration.apply(time).accept(locator);
        return locator;
    };

    MultiLocatorFunction<List<Locator>> eachToBeVisible = locators -> {
        Arrays.stream(locators).forEach(locator -> WaitFunctions.waitForToBeVisible.accept(locator));
        return List.of(locators);
    };

    UnaryOperator<Locator> toBePresent = locator -> {
        WaitFunctions.waitForLocatorToBePresent.accept(locator);
        return locator;
    };

    Function<Interval, UnaryOperator<Locator>> toBePresentWithInDuration = time -> locator -> {
        WaitFunctions.waitForLocatorToBePresentWithInDuration.apply(time).accept(locator);
        return locator;
    };

    MultiLocatorFunction<List<Locator>> eachToBePresent = locators -> {
        Arrays.stream(locators).forEach(locator -> WaitFunctions.waitForLocatorToBePresent.accept(locator));
        return List.of(locators);
    };

    UnaryOperator<Locator> toBeInvisible = locator -> {
        WaitFunctions.waitForToBeInvisible.accept(locator);
        return locator;
    };

    Function<Interval, UnaryOperator<Locator>> toBeInvisibleWithInDuration = time -> locator -> {
        WaitFunctions.waitForToBeInvisibleWithInDuration.apply(time).accept(locator);
        return locator;
    };

    MultiLocatorFunction<List<Locator>> eachToBeInvisible = locators -> {
        Arrays.stream(locators).forEach(locator -> WaitFunctions.waitForToBeInvisible.accept(locator));
        return List.of(locators);
    };

    UnaryOperator<Locator> toBeNotClickable = locator -> {
        WaitFunctions.waitForNotToBeClickable.accept(locator);
        return locator;
    };

    Function<String, UnaryOperator<Locator>> toBeText = value -> locator -> {
        WaitFunctions.waitForToBeText.apply(value).accept(locator);
        return locator;
    };

    Function<String, UnaryOperator<Locator>> toBeNotText = value -> locator -> {
        WaitFunctions.waitForNotToBeText.apply(value).accept(locator);
        return locator;
    };

    Function<String, UnaryOperator<Locator>> toBeTextMatch = value -> locator -> {
        WaitFunctions.waitForTextMatch.apply(value).accept(locator);
        return locator;
    };

    Function<Attribute, UnaryOperator<Locator>> toBeContainsAttribute = attribute -> locator -> {
        WaitFunctions.waitForContainsAttribute.apply(attribute).accept(locator);
        return locator;
    };

    Function<Attribute, UnaryOperator<Locator>> toBeNotEmptyAttribute = attribute -> locator -> {
        WaitFunctions.waitForAttributeToBeNotEmpty.apply(attribute).accept(locator);
        return locator;
    };

    Function<Attribute, UnaryOperator<Locator>> toBeAttributeHasValue = attribute -> locator -> {
        WaitFunctions.waitForAttributeHasValue.apply(attribute).accept(locator);
        return locator;
    };

    Function<Attribute, UnaryOperator<Locator>> toBeAttributeToNotHaveValue = attribute -> locator -> {
        WaitFunctions.waitForAttributeToNotHaveValue.apply(attribute).accept(locator);
        return locator;
    };

    Consumer<Locator> toBeInFrame = locator -> WaitFunctions.waitForSwitchToFrame.apply(locator);

    Function<Interval,Consumer<Locator>> toBeInFrameWithInDuration = time -> locator -> WaitFunctions.waitForSwitchToFrameWithInDuration.apply(time).apply(locator);

    Runnable waitForAngularToFinishProcessing = () -> WaitFunctions.waitForAngularToFinishProcessing.run();

    Runnable waitForJQueryActiveConnectionsToFinish = () -> WaitFunctions.waitForJQueryActiveConnectionsToFinish.run();

    static UnaryOperator<Locator> toBeNotText(final String value) {
        return locator -> toBeNotText.apply(value).apply(locator);
    }

    static UnaryOperator<Locator> toBeText(final String value) {
        return locator -> toBeText.apply(value).apply(locator);
    }

    static UnaryOperator<Locator> toBeInvisibleWithInDuration(final Interval interval) {
        return locator -> toBeInvisibleWithInDuration.apply(interval).apply(locator);
    }

    static UnaryOperator<Locator> toBePresentWithInDuration(final Interval interval) {
        return locator -> toBePresentWithInDuration.apply(interval).apply(locator);
    }

    static UnaryOperator<Locator> toBeVisibleWithInDuration(final Interval interval) {
        return locator -> toBeVisibleWithInDuration.apply(interval).apply(locator);
    }

    static UnaryOperator<Locator> toBeClickableWithInDuration(final Interval interval) {
        return locator -> toBeClickableWithInDuration.apply(interval).apply(locator);
    }
}