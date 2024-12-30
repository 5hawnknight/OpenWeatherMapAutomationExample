package org.themelios.core.waits;

import org.openqa.selenium.WebDriver;
import org.themelios.core.locator.Locator;
import org.themelios.core.time.Interval;
import org.themelios.models.Attribute;

import java.util.function.Consumer;
import java.util.function.Function;

import static org.themelios.core.waits.DriverWait.getWait;

interface WaitFunctions {
    Consumer<Locator> waitForToBeClickable = locator -> getWait(Interval.DEFAULT).until(ExpectedConditionsFactory.elementToBeClickable.apply(locator.selector()));
    Function<Interval,Consumer<Locator>> waitForToBeClickableWithInDuration = interval -> locator -> DriverWait.getWait(interval).until(ExpectedConditionsFactory.elementToBeClickable.apply(locator.selector()));
    Consumer<Locator> waitForToBeVisible = locator -> getWait(Interval.DEFAULT).until(ExpectedConditionsFactory.elementToBeVisible.apply(locator.selector()));
    Function<Interval,Consumer<Locator>> waitForToBeVisibleWithInDuration = interval -> locator -> getWait(interval).until(ExpectedConditionsFactory.elementToBeVisible.apply(locator.selector()));
    Consumer<Locator> waitForLocatorToBePresent = locator -> getWait(Interval.DEFAULT).until(ExpectedConditionsFactory.elementToBePresent.apply(locator.selector()));
    Function<Interval,Consumer<Locator>> waitForLocatorToBePresentWithInDuration = interval -> locator -> getWait(interval).until(ExpectedConditionsFactory.elementToBePresent.apply(locator.selector()));
    Consumer<Locator> waitForToBeInvisible = locator -> getWait(Interval.DEFAULT).until(ExpectedConditionsFactory.elementToBeInvisible.apply(locator.selector()));
    Function<Interval,Consumer<Locator>> waitForToBeInvisibleWithInDuration = interval -> locator -> getWait(interval).until(ExpectedConditionsFactory.elementToBeInvisible.apply(locator.selector()));
    Consumer<Locator> waitForNotToBeClickable = locator -> getWait(Interval.DEFAULT).until(ExpectedConditionsFactory.elementToBeNotClickable.apply(locator.selector()));
    Function<String, Consumer<Locator>> waitForToBeText = value -> locator -> getWait(Interval.DEFAULT).until(ExpectedConditionsFactory.elementTextToBe.apply(locator.selector()).apply(value));
    Function<String, Consumer<Locator>> waitForNotToBeText = value -> locator -> getWait(Interval.DEFAULT).until(ExpectedConditionsFactory.elementTextNotToBe.apply(locator.selector()).apply(value));
    Function<String, Consumer<Locator>> waitForTextMatch = value -> locator -> getWait(Interval.DEFAULT).until(ExpectedConditionsFactory.elementTextMatches.apply(locator.selector()).apply(value));
    Function<Attribute, Consumer<Locator>> waitForAttributeHasValue = attribute ->  locator -> getWait(Interval.DEFAULT).until(ExpectedConditionsFactory.attributeHasValue(locator.selector(),attribute));
    Function<Attribute, Consumer<Locator>> waitForAttributeToBeNotEmpty = attribute ->  locator -> getWait(Interval.DEFAULT).until(ExpectedConditionsFactory.attributeToBeNotEmpty.apply(locator.element()).apply(attribute));
    Function<Attribute, Consumer<Locator>> waitForContainsAttribute = attribute ->  locator -> getWait(Interval.DEFAULT).until(ExpectedConditionsFactory.containsAttribute(locator.selector(),attribute));
    Function<Attribute, Consumer<Locator>> waitForAttributeToNotHaveValue = attribute ->  locator -> getWait(Interval.DEFAULT).until(ExpectedConditionsFactory.attributeToNotHaveValue.apply(locator.selector()).apply(attribute));
    Function<Locator, WebDriver> waitForSwitchToFrame = locator -> getWait(Interval.DEFAULT).until(ExpectedConditionsFactory.switchToFrame.apply(locator.selector()));
    Function<Interval, Function<Locator,WebDriver>> waitForSwitchToFrameWithInDuration = interval -> locator -> getWait(interval).until(ExpectedConditionsFactory.switchToFrame.apply(locator.selector()));
    Runnable waitForAngularToFinishProcessing = () ->
            getWait(Interval.DEFAULT).until(ExpectedConditionsFactory.angularProcessingFinish());
    Runnable waitForJQueryActiveConnectionsToFinish = () ->
            getWait(Interval.DEFAULT).until(ExpectedConditionsFactory.jQueryActiveConnectionsFinish());

}