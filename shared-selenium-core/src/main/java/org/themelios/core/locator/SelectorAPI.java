/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022-2022.
 */

package org.themelios.core.locator;

import java.util.function.Function;

public interface SelectorAPI {

    Function<String, Locator> css = value -> LocatorBuilder.of(ByBuilder.CSS.of(value));
    Function<String, Locator> xpath = value -> LocatorBuilder.of(ByBuilder.XPATH.of(value));
    Function<String, Locator> id = value -> LocatorBuilder.of(ByBuilder.ID.of(value));
    Function<String, Locator> name = value -> LocatorBuilder.of(ByBuilder.NAME.of(value));
    Function<String, Locator> className = value -> LocatorBuilder.of(ByBuilder.CLASS_NAME.of(value));
    Function<String, Locator> tagName = value -> LocatorBuilder.of(ByBuilder.TAG_NAME.of(value));
    Function<String, Locator> linkText = value -> LocatorBuilder.of(ByBuilder.LINK_TEXT.of(value));
    Function<String, Locator> partialLinkText = value -> LocatorBuilder.of(ByBuilder.PARTIAL_LINK_TEXT.of(value));

    static Locator css(final String value) {
        return css.apply(value);
    }

    static Locator xpath(final String value) {
        return xpath.apply(value);
    }

    static Locator id(final String value) {
        return id.apply(value);
    }

    static Locator name(final String value) {
        return name.apply(value);
    }

    static Locator className(final String value) {
        return className.apply(value);
    }

    static Locator tagName(final String value) {
        return tagName.apply(value);
    }

    static Locator linkText(final String value) {
        return linkText.apply(value);
    }

    static Locator partialLinkText(final String value) {
        return partialLinkText.apply(value);
    }

    static Locator find(final Function<String, Locator> function, final String value) {
        return function.apply(value);
    }
}