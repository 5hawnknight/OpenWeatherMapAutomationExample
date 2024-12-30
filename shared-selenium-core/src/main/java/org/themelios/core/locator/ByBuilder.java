/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.locator;

import org.openqa.selenium.By;

enum ByBuilder {
    CSS {
        @Override
        public By of(final String value) {
            return By.cssSelector(value);
        }
    },
    XPATH {
        @Override
        public By of(final String value) {
            return By.xpath(value);
        }
    },
    ID {
        @Override
        public By of(final String value) {
            return By.id(value);
        }
    },
    NAME {
        @Override
        public By of(final String value) {
            return By.name(value);
        }
    },
    CLASS_NAME {
        @Override
        public By of(final String value) {
            return By.className(value);
        }
    },
    TAG_NAME {
        @Override
        public By of(final String value) {
            return By.tagName(value);
        }
    },
    LINK_TEXT {
        @Override
        public By of(final String value) {
            return By.linkText(value);
        }
    },
    PARTIAL_LINK_TEXT {
        @Override
        public By of(final String value) {
            return By.partialLinkText(value);
        }
    };
    abstract By of(final String value);
}