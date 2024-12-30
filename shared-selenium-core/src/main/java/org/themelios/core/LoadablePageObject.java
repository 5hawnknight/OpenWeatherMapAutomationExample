/*
 * Author: Shawn Knight
 * Github Project: https://github.com/5hawnknight/themelios
 * License: GNU GENERAL PUBLIC LICENSE Version 3
 * Copyright (c) 2022.
 */

package org.themelios.core;

import org.themelios.core.emulation.EmulationAPI;
import org.themelios.core.js.JSExecutionAPI;
import org.themelios.core.locator.LocatorAPI;
import org.themelios.core.locator.SelectorAPI;
import org.themelios.core.utilities.UtilitiesAPI;
import org.themelios.core.waits.WaitAPI;

@FunctionalInterface
public interface LoadablePageObject<T>  extends LocatorAPI, SelectorAPI, WaitAPI, EmulationAPI, JSExecutionAPI, UtilitiesAPI {
    default T get() {
        this.pageObjectInitializer();
        return (T) this;
    }
    void pageObjectInitializer();
}