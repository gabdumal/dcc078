/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.sensors;

import java.util.Observable;

public class Sensor
        extends Observable {

    private SensorState state;

    public Sensor() {
        this.state = DisarmedSensor.getInstance();
    }

    public SensorState getState() {
        return this.state;
    }

    public void setState(SensorState state) {
        this.state = state;
        this.notifyAlarms(state == TriggeredSensor.getInstance());
    }

    private void notifyAlarms(boolean on) {
        this.setChanged();
        this.notifyObservers(on);
    }

    public boolean arm() {
        return this.state.arm(this);
    }

    public boolean trigger() {
        return this.state.trigger(this);
    }

    public boolean reset() {
        return this.state.reset(this);
    }

    public boolean disarm() {
        return this.state.disarm(this);
    }

}
