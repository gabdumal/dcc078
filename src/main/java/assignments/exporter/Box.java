/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.exporter;

import java.util.ArrayList;

public class Box
        implements InventoryItem {

    private final ArrayList<Product> products;

    public Box(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public void accept(InventoryVisitor visitor) {
        visitor.visitBox(this);
    }

}