/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.models;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.themelios.core.locator.Locator;

import java.util.List;

public class ShadowRoot {

    private SearchContext searchContext;

    public ShadowRoot(SearchContext searchContext) {
        this.searchContext = searchContext;
    }
    public List<WebElement> elements(Locator locator) {
        return searchContext.findElements(locator.selector());
    }
    public WebElement element(Locator locator){
        return searchContext.findElement(locator.selector());
    }
}
