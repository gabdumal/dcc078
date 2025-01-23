/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.shipping.orderState;

import assignments.shipping.Order;
import assignments.shipping.OrderStateEnum;

public class DeliveredOrder
        extends OrderState {

    private static final DeliveredOrder instance = new DeliveredOrder();

    private DeliveredOrder() {
    }

    public static DeliveredOrder getInstance() {
        return DeliveredOrder.instance;
    }

    public OrderStateEnum getState() {
        return OrderStateEnum.DELIVERED;
    }

    @Override
    public double getPaidValue(Order order) {
        return order.getPrice() + order.getShippingFee();
    }

    @Override
    public boolean returnToStore(Order order) {
        order.setState(ReturnedOrder.getInstance());
        return true;
    }

}
