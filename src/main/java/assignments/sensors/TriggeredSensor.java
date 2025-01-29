/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.sensors;

public class TriggeredSensor
        extends SensorState {

    private static final TriggeredSensor instance = new TriggeredSensor();

    private TriggeredSensor() {
    }

    public static TriggeredSensor getInstance() {
        return instance;
    }

    @Override
    public SensorStateEnum getState() {
        return SensorStateEnum.TRIGGERED;
    }

    @Override
    public boolean reset(Sensor sensor) {
        sensor.setState(ArmedSensor.getInstance());
        return true;
    }

}
