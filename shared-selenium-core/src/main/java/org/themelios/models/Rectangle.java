/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.models;

import java.util.Optional;

public record Rectangle(Integer x, Integer y, Integer height, Integer width) implements Convertible {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Integer x       = 0;
        private Integer y       = 0;
        private Integer height  = 0;
        private Integer width   = 0;

        public Builder x(Integer x) {
            Optional.ofNullable(x).ifPresent(i -> this.x = i);
            return this;
        }
        public Builder y(Integer y) {
            Optional.ofNullable(y).ifPresent(i -> this.y = i);
            return this;
        }
        public Builder height(Integer height) {
            Optional.ofNullable(height).ifPresent(i -> this.height = i);
            return this;
        }
        public Builder width(Integer width) {
            Optional.ofNullable(width).ifPresent(i -> this.width = i);
            return this;
        }
        public Rectangle build() {
            return new Rectangle(x,y,height,width);
        }
    }
}