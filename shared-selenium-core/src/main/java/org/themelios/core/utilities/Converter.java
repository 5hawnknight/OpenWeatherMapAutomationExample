/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.utilities;

import org.openqa.selenium.NoSuchShadowRootException;
import org.openqa.selenium.SearchContext;
import org.themelios.models.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

public interface Converter {

    Function<Set<org.openqa.selenium.Cookie>, Cookies> toCookies = cookies ->
        Cookies.of(Optional.ofNullable(cookies).orElseGet(() -> new HashSet<>()).stream().map(c -> Cookie.builder()
                .name(c.getName())
                .value(c.getValue())
                .domain(c.getDomain())
                .path(c.getPath())
                .expiry(c.getExpiry())
                .isSecure(c.isSecure())
                .isHttpOnly(c.isHttpOnly())
                .sameSite(c.getSameSite())
                .build())
                .toList());

    Function<org.openqa.selenium.Dimension, Dimension> toDimension = d -> Dimension.builder().width(d.width).height(d.height).build();

    Function<org.openqa.selenium.Point, Point> toPoint = p -> Point.builder().x(p.x).y(p.y).build();

    Function<org.openqa.selenium.Rectangle, Rectangle> toRectangle = r -> Rectangle.builder().x(r.x).y(r.y).width(r.width).height(r.height).build();

    static Rectangle rectangle(final org.openqa.selenium.Point point, final org.openqa.selenium.Dimension dimension) {
        return Rectangle.builder().x(point.x).y(point.y).width(dimension.width).height(dimension.height).build();
    }
    Function<SearchContext,ShadowRoot> toShadowRoot = searchContext ->
            new ShadowRoot(Optional.ofNullable(searchContext)
                    .orElseThrow(() -> new NoSuchShadowRootException("failed conversion of SearchContext (likely null) to ShadowRoot")));

    static <T> T revert(final Convertible object) {
        return (T) switch (object) {
            case Dimension d -> new org.openqa.selenium.Dimension(d.width(),d.height());
            case Point p ->  new org.openqa.selenium.Point(p.x(),p.y());
            case Rectangle r -> new org.openqa.selenium.Rectangle(r.x(),r.y(),r.height(),r.width());
        };
    }
}