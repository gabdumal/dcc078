/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.shipping;

public class Order {

    private final String code;
    private final double price;
    private final double shippingFee;
    private OrderState state;

    public Order(
            String code,
            double price,
            double shippingFee
    ) {
        this.code        = code;
        this.price       = price;
        this.shippingFee = shippingFee;
        this.state       = PendingOrder.getInstance();
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState orderState) {
        this.state = orderState;
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public double getPaidValue() {
        return this.state.getPaidValue(this);
    }

    public boolean pay() {
        return this.state.pay(this);
    }

    public boolean cancel() {
        return this.state.cancel(this);
    }

    public boolean ship() {
        return this.state.ship(this);
    }

    public boolean deliver() {
        return this.state.deliver(this);
    }

    public boolean returnToStore() {
        return this.state.returnToStore(this);
    }

}
