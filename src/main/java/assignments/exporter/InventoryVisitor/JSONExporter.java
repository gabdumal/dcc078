/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.exporter.InventoryVisitor;

import assignments.exporter.InventoryItem.Box;
import assignments.exporter.InventoryItem.InventoryItem;
import assignments.exporter.InventoryItem.Pallet;
import assignments.exporter.InventoryItem.Product;

public class JSONExporter
        implements InventoryVisitor {

    public String print(InventoryItem item) {
        return item.accept(this);
    }

    @Override
    public String printProduct(Product product) {
        return String.format(
                "{\"type\": \"Product\", \"name\": \"%s\", \"weight\": %.2f, \"price\": %.2f}",
                product.getName()
                       .replace("\"", "\\\""),
                product.getWeight(),
                product.getPrice()
        );
    }

    @Override
    public String printBox(Box box) {
        StringBuilder output = new StringBuilder();

        output.append(String.format(
                "{\"type\": \"Box\", \"color\": \"%s\", \"products\": [",
                box.getColor()
                   .replace("\"", "\\\"")
        ));

        for (Product product : box.getProducts()) {
            output.append(product.accept(this));
            output.append(", ");
        }

        if (!box.getProducts()
                .isEmpty()) {
            output.delete(output.length() - 2, output.length()); // Remove trailing comma
        }

        output.append("]}");
        return output.toString();
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
