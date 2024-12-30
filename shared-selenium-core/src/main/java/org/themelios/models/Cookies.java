/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.models;

import java.util.List;
import java.util.stream.Stream;

public record Cookies(List<Cookie> cookies) {

    public Stream<Cookie> stream() {
        return cookies.stream();
    }
    public static Cookies of (List<Cookie> cookies) {
        return new Cookies(cookies);
    }
}