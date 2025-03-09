/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.exporter.InventoryItem;

import assignments.exporter.InventoryVisitor.InventoryVisitor;

public class Product
        implements InventoryItem {

    private final String name;
    private final double weight;
    private final double price;

    public Product(
            String name,
            double weight,
            double price
    ) {
        this.name   = name;
        this.weight = weight;
        this.price  = price;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String accept(InventoryVisitor visitor) {
        return visitor.printProduct(this);
    }

}
