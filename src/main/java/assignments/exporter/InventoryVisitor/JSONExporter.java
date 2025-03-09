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
            output.append(this.printProduct(product));
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
        StringBuilder output = new StringBuilder();

        output.append("{\"type\": \"Box\", \"boxes\": [");

        for (Box box : pallet.getBoxes()) {
            output.append(this.printBox(box));
            output.append(", ");
        }

        if (!pallet.getBoxes()
                   .isEmpty()) {
            output.delete(output.length() - 2, output.length()); // Remove trailing comma
        }

        output.append("]}");
        return output.toString();
    }

}
