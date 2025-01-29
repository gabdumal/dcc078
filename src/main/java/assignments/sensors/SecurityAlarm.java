/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.sensors;

import java.util.Observable;
import java.util.Observer;

public class SecurityAlarm
        implements Observer {

    private boolean isOn = false;
    private String location;

    public SecurityAlarm(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void register(Sensor sensor) {
        sensor.addObserver(this);
    }

    @Override
    public void update(Observable sensor, Object on) {
        if (on instanceof Boolean) {
            this.isOn = (Boolean) on;
        }
    }

}
