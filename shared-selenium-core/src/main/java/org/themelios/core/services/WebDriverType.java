/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.services;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.function.Function;

public interface WebDriverType
{
	Function<URL, Function<Capabilities,WebDriver>> implement = url -> capabilities -> new RemoteWebDriver(url,capabilities);

	WebDriver getWebDriver();
	boolean isWebDriverType(String type);
}
