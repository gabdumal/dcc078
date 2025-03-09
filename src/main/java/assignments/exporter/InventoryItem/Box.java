/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.exporter.InventoryItem;

import assignments.exporter.InventoryVisitor.InventoryVisitor;

import java.util.ArrayList;

public class Box
        implements InventoryItem {

    private final String             color;
    private final ArrayList<Product> products;

    public Box(
            String color,
            ArrayList<Product> products
    ) {
        this.color    = color;
        this.products = products;
    }

    public String getColor() {
        return color;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String accept(InventoryVisitor visitor) {
        return visitor.printBox(this);
    }

}