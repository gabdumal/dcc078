/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.shipping.orderState;

import assignments.shipping.Order;
import assignments.shipping.OrderStateEnum;

public abstract class OrderState {

    public abstract OrderStateEnum getState();

    public abstract double getPaidValue(Order order);

    public boolean pay(Order order) {
        return false;
    }

    public boolean confirm(Order order) {
        return false;
    }

    public boolean cancel(Order order) {
        return false;
    }

}
