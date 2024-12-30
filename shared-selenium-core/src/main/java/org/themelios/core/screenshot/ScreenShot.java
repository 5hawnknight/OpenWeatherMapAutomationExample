/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core.screenshot;

import java.io.File;

import static org.themelios.handlers.DriverHandler.*;

/**
 *  default path: build/screenshots/
 *  requirement: '/' at the end of the path
 *  the file name will be appended with '.png'
 */
public interface ScreenShot
{
    static ScreenShotBuilder take() {
        return new ScreenShotBuilder(ScreenShotFileHandler.getFile.apply(driver()));
    }

    class ScreenShotBuilder {

        private File file;
        private String path = "build/screenshots/";
        private ScreenShotBuilder() {}

        public ScreenShotBuilder(File file) {
            this.file = file;
        }

        public File file() {
            return this.file;
        }

        public ScreenShotBuilder path(String path) {
            this.path = path;
            return this;
        }

        public void save(String name) {
            ScreenShotFileHandler.save.apply(path).apply(name).accept(file);
        }
    }
}