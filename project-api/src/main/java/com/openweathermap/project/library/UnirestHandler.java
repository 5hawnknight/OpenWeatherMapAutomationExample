package com.openweathermap.project.library;

import kong.unirest.core.CookieSpecs;
import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestInstance;

import java.time.Duration;
import java.time.Instant;

public class UnirestHandler implements Log {
    private static final ThreadLocal<UnirestInstance> unirest = ThreadLocal.withInitial(()-> {
        var _unirest =  Unirest.spawnInstance();
        _unirest.config()
                .connectTimeout(60_000)
                .connectionTTL(Duration.ofMinutes(1))
                .cookieSpec(CookieSpecs.STANDARD);
        return _unirest;
    });

    public static UnirestInstance instance() {
        unirest.get().config()
                .instrumentWith(_ -> {
                    var start = Instant.now();
                    return (responseSummary, _) -> Log.logger(UnirestHandler.class).info(
                            buildMessage(responseSummary.getStatus(), getDuration(start)));
                });
        return unirest.get();
    }
    private static String buildMessage(Integer status, String duration) {
        return String.format("Response: status: %s | %s\n", status, duration);
    }
    private static String getDuration(Instant start) {
        var end = Instant.now();
        var duration = Duration.between(start,end).toString().replaceAll("[a-zA-Z]+","");
        return String.format("Duration: %s seconds",duration);
    }
}
