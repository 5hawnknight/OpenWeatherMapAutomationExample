/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

interface ScreenShotFileHandler {
    Predicate<WebDriver> isInstanceOfRemoteDriver = driver -> driver instanceof RemoteWebDriver;
    Function<WebDriver,File> remoteDriverScreenshotFile = driver -> ((TakesScreenshot) new Augmenter().augment(driver)).getScreenshotAs(OutputType.FILE);
    Function<WebDriver,File> webDriverScreenshotFile = driver ->  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    Function<WebDriver,File> getFile = driver -> isInstanceOfRemoteDriver.test(driver) ? remoteDriverScreenshotFile.apply(driver) :  webDriverScreenshotFile.apply(driver);

    Function<String,Function<String, Consumer<File>>> save = path -> name -> file -> {
        var fullPath = path.concat(name).concat(".png");
        try {
            FileUtils.copyFile(file, new File(String.format(fullPath, name)));
        }
        catch (IOException ioe) {
            // ADD LOGGER HERE//
        }
    };
}