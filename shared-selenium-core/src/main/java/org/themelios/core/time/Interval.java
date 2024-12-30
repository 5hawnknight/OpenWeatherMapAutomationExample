/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.time;

import java.time.Duration;

public enum Interval {
    ONE_SECOND,
    FIVE_SECONDS,
    TEN_SECONDS,
    FIFTEEN_SECONDS,
    THIRTY_SECONDS,
    FORTY_FIVE_SECONDS,
    SIXTY_SECONDS,
    NINETY_SECONDS,
    TWO_MINUTES,
    DEFAULT;

    private static Duration defaultDuration = Duration.ofSeconds(60L);

    public static void setDefault(Duration duration) {
        defaultDuration = duration;
    }

    public static Duration of(final Interval interval) {
        return switch (interval) {
            case ONE_SECOND -> Duration.ofSeconds(1L);
            case FIVE_SECONDS -> Duration.ofSeconds(5L);
            case TEN_SECONDS -> Duration.ofSeconds(10L);
            case FIFTEEN_SECONDS -> Duration.ofSeconds(15L);
            case THIRTY_SECONDS -> Duration.ofSeconds(30L);
            case FORTY_FIVE_SECONDS -> Duration.ofSeconds(45L);
            case SIXTY_SECONDS -> Duration.ofSeconds(60L);
            case NINETY_SECONDS -> Duration.ofSeconds(90L);
            case TWO_MINUTES -> Duration.ofSeconds(120L);
            case DEFAULT -> defaultDuration;
        };
    }
}