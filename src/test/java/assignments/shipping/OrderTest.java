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

    /* Pending Order */

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

    /* Processing Order */

    @Test
    public void paidValueShouldBeFullOnProcessingOrder() {
        this.order.setState(ProcessingOrder.getInstance());

        assertEquals(345.4d, this.order.getPaidValue(), 0.01d);
    }

    @Test
    public void shouldNotPayProcessingOrder() {
        this.order.setState(ProcessingOrder.getInstance());

        assertFalse(this.order.pay());
        assertEquals(ProcessingOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldCancelProcessingOrder() {
        this.order.setState(ProcessingOrder.getInstance());

        assertTrue(this.order.cancel());
        assertEquals(CancelledOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldShipProcessingOrder() {
        this.order.setState(ProcessingOrder.getInstance());

        assertTrue(this.order.ship());
        assertEquals(ShippedOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotDeliverProcessingOrder() {
        this.order.setState(ProcessingOrder.getInstance());

        assertFalse(this.order.deliver());
        assertEquals(ProcessingOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotReturnProcessingOrder() {
        this.order.setState(ProcessingOrder.getInstance());

        assertFalse(this.order.returnToStore());
        assertEquals(ProcessingOrder.getInstance(), this.order.getState());
    }

    /* Shipped Order */

    @Test
    public void paidValueShouldBeFullOnShippedOrder() {
        this.order.setState(ShippedOrder.getInstance());

        assertEquals(345.4d, this.order.getPaidValue(), 0.01d);
    }

    @Test
    public void shouldNotPayShippedOrder() {
        this.order.setState(ShippedOrder.getInstance());

        assertFalse(this.order.pay());
        assertEquals(ShippedOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotCancelShippedOrder() {
        this.order.setState(ShippedOrder.getInstance());

        assertFalse(this.order.cancel());
        assertEquals(ShippedOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotShipShippedOrder() {
        this.order.setState(ShippedOrder.getInstance());

        assertFalse(this.order.ship());
        assertEquals(ShippedOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldDeliverShippedOrder() {
        this.order.setState(ShippedOrder.getInstance());

        assertTrue(this.order.deliver());
        assertEquals(DeliveredOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldReturnShippedOrder() {
        this.order.setState(ShippedOrder.getInstance());

        assertTrue(this.order.returnToStore());
        assertEquals(ReturnedOrder.getInstance(), this.order.getState());
    }

    /* Delivered Order */

    @Test
    public void paidValueShouldBeFullOnDeliveredOrder() {
        this.order.setState(DeliveredOrder.getInstance());

        assertEquals(345.4d, this.order.getPaidValue(), 0.01d);
    }

    @Test
    public void shouldNotPayDeliveredOrder() {
        this.order.setState(DeliveredOrder.getInstance());

        assertFalse(this.order.pay());
        assertEquals(DeliveredOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotCancelDeliveredOrder() {
        this.order.setState(DeliveredOrder.getInstance());

        assertFalse(this.order.cancel());
        assertEquals(DeliveredOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotShipDeliveredOrder() {
        this.order.setState(DeliveredOrder.getInstance());

        assertFalse(this.order.ship());
        assertEquals(DeliveredOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotDeliverDeliveredOrder() {
        this.order.setState(DeliveredOrder.getInstance());

        assertFalse(this.order.deliver());
        assertEquals(DeliveredOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldReturnDeliveredOrder() {
        this.order.setState(DeliveredOrder.getInstance());

        assertTrue(this.order.returnToStore());
        assertEquals(ReturnedOrder.getInstance(), this.order.getState());
    }

    /* Cancelled Order */

    @Test
    public void paidValueShouldBeZeroOnCancelledOrder() {
        this.order.setState(CancelledOrder.getInstance());

        assertEquals(0.0d, this.order.getPaidValue(), 0.01d);
    }

    @Test
    public void shouldNotPayCancelledOrder() {
        this.order.setState(CancelledOrder.getInstance());

        assertFalse(this.order.pay());
        assertEquals(CancelledOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotCancelCancelledOrder() {
        this.order.setState(CancelledOrder.getInstance());

        assertFalse(this.order.cancel());
        assertEquals(CancelledOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotShipCancelledOrder() {
        this.order.setState(CancelledOrder.getInstance());

        assertFalse(this.order.ship());
        assertEquals(CancelledOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotDeliverCancelledOrder() {
        this.order.setState(CancelledOrder.getInstance());

        assertFalse(this.order.deliver());
        assertEquals(CancelledOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotReturnCancelledOrder() {
        this.order.setState(CancelledOrder.getInstance());

        assertFalse(this.order.returnToStore());
        assertEquals(CancelledOrder.getInstance(), this.order.getState());
    }

    /* Returned Order */

    @Test
    public void paidValueShouldBeOnlyShippingFeeOnReturnedOrder() {
        this.order.setState(ReturnedOrder.getInstance());

        assertEquals(19.5d, this.order.getPaidValue(), 0.01d);
    }

    @Test
    public void shouldNotPayReturnedOrder() {
        this.order.setState(ReturnedOrder.getInstance());

        assertFalse(this.order.pay());
        assertEquals(ReturnedOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotCancelReturnedOrder() {
        this.order.setState(ReturnedOrder.getInstance());

        assertFalse(this.order.cancel());
        assertEquals(ReturnedOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotShipReturnedOrder() {
        this.order.setState(ReturnedOrder.getInstance());

        assertFalse(this.order.ship());
        assertEquals(ReturnedOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotDeliverReturnedOrder() {
        this.order.setState(ReturnedOrder.getInstance());

        assertFalse(this.order.deliver());
        assertEquals(ReturnedOrder.getInstance(), this.order.getState());
    }

    @Test
    public void shouldNotReturnReturnedOrder() {
        this.order.setState(ReturnedOrder.getInstance());

        assertFalse(this.order.returnToStore());
        assertEquals(ReturnedOrder.getInstance(), this.order.getState());
    }

}