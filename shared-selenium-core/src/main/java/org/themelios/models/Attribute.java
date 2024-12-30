/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.models;

public record Attribute(String name, String value) {

    public static Attribute of(final String name, final String value) {
        return new Attribute(name,value);
    }
    public static Attribute of(final String name) {
        return new Attribute(name,"");
    }
}