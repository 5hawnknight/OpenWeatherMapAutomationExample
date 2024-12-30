/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.services;

import org.openqa.selenium.WebDriver;

import java.util.function.Predicate;

public record WebDriverService(RegisterWebDrivers registerWebDrivers) {
	public WebDriver createInstance(String browserType)
	{
		return registerWebDrivers.getTypes().stream()
				.filter(isMatchWith(browserType))
				.findFirst()
				.map(registerWebDriver -> registerWebDriver.getWebDriver())
				.orElseThrow(() -> new RuntimeException(String.format("the browser type failed to find/match any registered WebDriver defined: %s",browserType)));
	}

	private Predicate<WebDriverType> isMatchWith(String type)
	{
		return registerWebDriver -> registerWebDriver.isWebDriverType(type);
	}
}