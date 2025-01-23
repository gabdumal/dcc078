/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.shipping;

import assignments.shipping.orderState.OrderState;
import assignments.shipping.orderState.PendingOrder;

public class Order {

    OrderState state;
    private String code;
    private double originalPrice;
    private double originalShippingFee;

    public Order() {
        this.state = PendingOrder.getInstance();
    }

    public void setState(OrderState orderState) {
        this.state = orderState;
    }

    public double getPaidValue() {
        return this.state.getPaidValue(this);
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getOriginalShippingFee() {
        return originalShippingFee;
    }

    public void setOriginalShippingFee(double originalShippingFee) {
        this.originalShippingFee = originalShippingFee;
    }

}
