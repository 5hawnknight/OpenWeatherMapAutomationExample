package org.themelios.core.utilities;

import org.themelios.core.locator.Locator;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public interface UtilitiesAPI {

    Function<Boolean, Boolean> not = value -> value == Boolean.FALSE;

    Function<Object, Boolean> exist = value -> Objects.nonNull(value);

    Function<Function<Locator, Boolean>, Function<Locator,Boolean>> ignoreExceptions = function -> locator -> {
        try {
            return function.apply(locator);
        } catch (Exception error) {
            return Boolean.FALSE;
        }
    };

    static <T> Boolean exist(final Function<Locator, T> function, final Locator locator) {
        return Objects.nonNull(function.apply(locator));
    }

    static Boolean not(final Function<Locator, Boolean> function, final Locator locator) {
        return function.apply(locator) == Boolean.FALSE;
    }

    static Boolean not(final Supplier<Boolean> function) {
        return function.get() == Boolean.FALSE;
    }

    static  <T> Optional<T> ignoreExceptions(final Function<Locator, T> function, final Locator locator) {
        try {
            T result = function.apply(locator);
            return Optional.of(result);
        } catch (Exception error) {
            return Optional.empty();
        }
    }

    static  <T> Optional<T> ignoreExceptions(final Function<String, Function<Locator, T>> function, final String value, final Locator locator) {
        try {
            return Optional.of(function.apply(value).apply(locator));
        } catch (Exception error) {
            return Optional.empty();
        }
    }

    static  <T> Optional<T> ignoreExceptions(final Function<Locator, Function<Supplier<Long>, T>> function, final Locator locator, final Supplier<Long> value) {
        try {
            return Optional.of(function.apply(locator).apply(value));
        } catch (Exception error) {
            return Optional.empty();
        }
    }
}