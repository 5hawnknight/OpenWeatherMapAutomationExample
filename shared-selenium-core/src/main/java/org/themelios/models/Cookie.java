/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.models;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public record Cookie(String name, String value, String path, String domain, Date expiry, Boolean isSecure, Boolean isHttpOnly, String sameSite) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String name         = "";
        private String value        = "";
        private String path         = "";
        private String domain       = "";
        private Date expiry         = Calendar.getInstance().getTime();
        private Boolean isSecure    = Boolean.FALSE;
        private Boolean isHttpOnly  = Boolean.TRUE;
        private String sameSite     = "";

        public Builder name(String name) {
            Optional.ofNullable(name).ifPresent(v -> this.name = v);
            return this;
        }
        public Builder value(String value) {
            Optional.ofNullable(value).ifPresent(v -> this.value = v);
            return this;
        }
        public Builder path(String path) {
            Optional.ofNullable(path).ifPresent(v -> this.path = v);
            return this;
        }
        public Builder domain(String domain) {
            Optional.ofNullable(domain).ifPresent(v -> this.domain = v);
            return this;
        }
        public Builder expiry(Date expiry) {
            Optional.ofNullable(expiry).ifPresent(v -> this.expiry = v);
            return this;
        }
        public Builder isSecure(Boolean isSecure) {
            Optional.ofNullable(isSecure).ifPresent(v -> this.isSecure = v);
            return this;
        }
        public Builder isHttpOnly(Boolean isHttpOnly) {
            Optional.ofNullable(isHttpOnly).ifPresent(v -> this.isHttpOnly = v);
            return this;
        }
        public Builder sameSite(String sameSite) {
            Optional.ofNullable(sameSite).ifPresent(v -> this.sameSite = v);
            return this;
        }
        public Cookie build() {
            return new Cookie(name,value,path,domain,expiry,isSecure,isHttpOnly,sameSite);
        }
    }
}