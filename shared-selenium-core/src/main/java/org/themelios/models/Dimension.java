/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.models;

import java.util.Optional;

public record Dimension(Integer width, Integer height) implements Convertible {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Integer height  = 0;
        private Integer width   = 0;

        public Builder height(Integer height) {
            Optional.ofNullable(height).ifPresent(i -> this.height = i);
            return this;
        }
        public Builder width(Integer width) {
            Optional.ofNullable(width).ifPresent(i -> this.width = i);
            return this;
        }
        public Dimension build() {
            return new Dimension(width,height);
        }
    }
}