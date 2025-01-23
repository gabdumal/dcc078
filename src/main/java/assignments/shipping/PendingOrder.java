/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.shipping;

public class PendingOrder
        extends OrderState {

    private static final PendingOrder instance = new PendingOrder();

    private PendingOrder() {
    }

    public static PendingOrder getInstance() {
        return PendingOrder.instance;
    }

    public OrderStateEnum getState() {
        return OrderStateEnum.PENDING;
    }

    @Override
    public double getPaidValue(Order order) {
        return 0;
    }

    @Override
    public boolean pay(Order order) {
        order.setState(ProcessingOrder.getInstance());
        return true;
    }

    @Override
    public boolean cancel(Order order) {
        order.setState(CancelledOrder.getInstance());
        return true;
    }

}
