/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.models;

import java.util.Optional;

public record Point(Integer x, Integer y) implements Convertible {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Integer x = 0;
        private Integer y = 0;

        public Builder x(Integer x) {
            Optional.ofNullable(x).ifPresent(i -> this.x = i);
            return this;
        }
        public Builder y(Integer y) {
            Optional.ofNullable(y).ifPresent(i -> this.y = i);
            return this;
        }
        public Point build() {
            return new Point(x,y);
        }
    }
}