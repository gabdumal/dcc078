/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.shipping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Order order;

    @BeforeEach
    public void setUp() {
        this.order = new Order("AXZ0389128", 325.90d, 19.50d);
    }

    @Test
    public void paidValueShouldBeZeroOnPendingOrder() {
        this.order.setState(PendingOrder.getInstance());

        assertEquals(0.0d, this.order.getPaidValue(), 0.01d);
    }

    @Test
    public void shouldPayPendingOrder() {
        this.order.setState(PendingOrder.getInstance());

        assertTrue(this.order.pay());
        assertEquals(ProcessingOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldCancelPendingOrder() {
        this.order.setState(PendingOrder.getInstance());

        assertTrue(this.order.cancel());
        assertEquals(CancelledOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotShipPendingOrder() {
        this.order.setState(PendingOrder.getInstance());

        assertFalse(this.order.ship());
        assertEquals(PendingOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotDeliverPendingOrder() {
        this.order.setState(PendingOrder.getInstance());

        assertFalse(this.order.deliver());
        assertEquals(PendingOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotReturnPendingOrder() {
        this.order.setState(PendingOrder.getInstance());

        assertFalse(this.order.returnToStore());
        assertEquals(PendingOrder.getInstance(), this.order.getState());
    }

}