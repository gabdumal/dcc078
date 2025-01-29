/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.sensors;

public class ArmedSensor
        extends SensorState {

    private static final ArmedSensor instance = new ArmedSensor();

    private ArmedSensor() {
    }

    public static ArmedSensor getInstance() {
        return instance;
    }

    @Override
    public SensorStateEnum getState() {
        return SensorStateEnum.ARMED;
    }

    @Override
    public boolean trigger(Sensor sensor) {
        sensor.setState(TriggeredSensor.getInstance());
        return true;
    }

    @Override
    public boolean disarm(Sensor sensor) {
        sensor.setState(DisarmedSensor.getInstance());
        return true;
    }

}
