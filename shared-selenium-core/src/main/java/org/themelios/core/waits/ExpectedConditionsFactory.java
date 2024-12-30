package org.themelios.core.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.themelios.models.Attribute;

import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Pattern;

interface ExpectedConditionsFactory {

    Function<By,ExpectedCondition<WebElement>> elementToBeClickable = ExpectedConditions::elementToBeClickable;
    Function<By,ExpectedCondition<Boolean>> elementToBeNotClickable = by -> ExpectedConditions.not(ExpectedConditions.elementToBeClickable(by));
    Function<By,ExpectedCondition<WebElement>> elementToBeVisible = ExpectedConditions::visibilityOfElementLocated;
    Function<By,ExpectedCondition<WebElement>> elementToBePresent = ExpectedConditions::presenceOfElementLocated;
    Function<By,ExpectedCondition<Boolean>> elementToBeInvisible = by -> ExpectedConditions.invisibilityOfElementLocated(by);
    Function<By,Function<String, ExpectedCondition<Boolean>>> elementTextToBe = by -> text -> ExpectedConditions.textToBe(by,text);
    Function<By,Function<String, ExpectedCondition<Boolean>>> elementTextNotToBe = by -> text -> ExpectedConditions.not(ExpectedConditions.textToBe(by,text));
    Function<By,ExpectedCondition<WebDriver>> switchToFrame = by -> ExpectedConditions.frameToBeAvailableAndSwitchToIt(by);
    Function<By,Function<String, ExpectedCondition<Boolean>>> elementTextMatches = by -> text -> ExpectedConditions.textMatches(by,Pattern.compile(text));
    Function<WebElement,Function<Attribute,ExpectedCondition<Boolean>>> attributeToBeNotEmpty = element -> attribute -> ExpectedConditions.attributeToBeNotEmpty(element,attribute.name());
    Function<By, Function<Attribute, ExpectedCondition<Boolean>>> attributeToNotHaveValue = by -> attribute -> ExpectedConditions.not(ExpectedConditions.attributeToBe(by, attribute.name(), attribute.value()));

    static ExpectedCondition<Boolean> containsAttribute(final By by, final Attribute attribute) {
        return driver -> Objects.nonNull(driver.findElement(by).getAttribute(attribute.name()));
    }

    static ExpectedCondition<Boolean> attributeHasValue(final By by, final Attribute attribute) {
        return driver -> driver.findElement(by).getAttribute(attribute.name()).equalsIgnoreCase(attribute.value());
    }

    static ExpectedCondition<Boolean> angularProcessingFinish() {
        return driver -> Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)").toString());
    }

    static ExpectedCondition<Boolean> jQueryActiveConnectionsFinish() {
        return driver -> Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return jQuery.active === 0").toString());
    }
}
