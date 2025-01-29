/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.sensors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SensorTest {

    private Sensor        sensor;
    private SecurityAlarm securityAlarm;

    @BeforeEach
    public void setUp() {
        this.sensor        = new Sensor();
        this.securityAlarm = new SecurityAlarm("Cozinha");
        this.securityAlarm.register(this.sensor);
    }

    /* DisarmedSensor */

    @Test
    public void shouldArmDisarmedSensor() {
        this.sensor.setState(DisarmedSensor.getInstance());

        assertTrue(this.sensor.arm());
        assertEquals(ArmedSensor.getInstance(), this.sensor.getState());
        assertFalse(this.securityAlarm.isOn());
    }

    @Test
    public void shouldNotTriggerDisarmedSensor() {
        this.sensor.setState(DisarmedSensor.getInstance());

        assertFalse(this.sensor.trigger());
        assertEquals(DisarmedSensor.getInstance(), this.sensor.getState());
        assertFalse(this.securityAlarm.isOn());
    }

    @Test
    public void shouldNotResetDisarmedSensor() {
        this.sensor.setState(DisarmedSensor.getInstance());

        assertFalse(this.sensor.reset());
        assertEquals(DisarmedSensor.getInstance(), this.sensor.getState());
        assertFalse(this.securityAlarm.isOn());
    }

    @Test
    public void shouldNotDisarmDisarmedSensor() {
        this.sensor.setState(DisarmedSensor.getInstance());

        assertFalse(this.sensor.disarm());
        assertEquals(DisarmedSensor.getInstance(), this.sensor.getState());
        assertFalse(this.securityAlarm.isOn());
    }

    /* ArmedSensor */

    @Test
    public void shouldNotArmArmedSensor() {
        this.sensor.setState(ArmedSensor.getInstance());

        assertFalse(this.sensor.arm());
        assertEquals(ArmedSensor.getInstance(), this.sensor.getState());
        assertFalse(this.securityAlarm.isOn());
    }

    @Test
    public void shouldTriggerArmedSensor() {
        this.sensor.setState(ArmedSensor.getInstance());

        assertTrue(this.sensor.trigger());
        assertEquals(TriggeredSensor.getInstance(), this.sensor.getState());
        assertTrue(this.securityAlarm.isOn());
    }

    @Test
    public void shouldNotResetArmedSensor() {
        this.sensor.setState(ArmedSensor.getInstance());

        assertFalse(this.sensor.reset());
        assertEquals(ArmedSensor.getInstance(), this.sensor.getState());
        assertFalse(this.securityAlarm.isOn());
    }

    @Test
    public void shouldDisarmArmedSensor() {
        this.sensor.setState(ArmedSensor.getInstance());

        assertTrue(this.sensor.disarm());
        assertEquals(DisarmedSensor.getInstance(), this.sensor.getState());
        assertFalse(this.securityAlarm.isOn());
    }

}
