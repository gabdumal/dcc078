/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.sensors;

public abstract class SensorState {

    public abstract SensorStateEnum getState();

    public boolean arm(Sensor sensor) {
        return false;
    }

    public boolean trigger(Sensor sensor) {
        return false;
    }

    public boolean reset(Sensor sensor) {
        return false;
    }

    public boolean disarm(Sensor sensor) {
        return false;
    }

}
