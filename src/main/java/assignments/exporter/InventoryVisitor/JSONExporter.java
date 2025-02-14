/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.exporter.InventoryVisitor;

import assignments.exporter.InventoryItem.Box;
import assignments.exporter.InventoryItem.Pallet;
import assignments.exporter.InventoryItem.Product;

public class JSONExporter
        implements InventoryVisitor {

    @Override
    public String printProduct(Product product) {
        return String.format(
                "{\"type\": \"Product\", \"name\": \"%s\", \"weight\": %.2f, \"price\": %.2f}%n",
                product.getName()
                       .replace("\"", "\\\""),
                product.getWeight(),
                product.getPrice()
        );
    }

    @Override
    public String printBox(Box box) {
        var totalWeight = 0d;
        var totalPrice  = 0d;

        for (var product : box.getProducts()) {
            totalWeight += product.getWeight();
            totalPrice += product.getPrice();
        }

        return String.format("\"Caixa\",\"%s\",%.2f,%.2f%n", box.getColor(), totalWeight, totalPrice);
    }

    @Override
    public String printPallet(Pallet pallet) {
        var totalWeight = 0d;
        var totalPrice  = 0d;

        for (var box : pallet.getBoxes()) {
            for (var product : box.getProducts()) {
                totalWeight += product.getWeight();
                totalPrice += product.getPrice();
            }
        }

        return String.format("\"Pallet\",%.2f,%.2f%n", totalWeight, totalPrice);
    }

}
