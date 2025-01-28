/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.shipping;

public class ReturnedOrder
        extends OrderState {

    private static final ReturnedOrder instance = new ReturnedOrder();
    private              boolean       hasShipped;

    private ReturnedOrder() {
    }

    public static ReturnedOrder getInstance() {
        return ReturnedOrder.instance;
    }

    public OrderStateEnum getState() {
        return OrderStateEnum.RETURNED;
    }

    @Override
    public double getPaidValue(Order order) {
        return order.getShippingFee();
    }

}
