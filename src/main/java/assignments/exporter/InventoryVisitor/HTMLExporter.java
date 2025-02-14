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

public class HTMLExporter
        implements InventoryVisitor {

    public String print(InventoryItem item) {
        return "<ul>\n" + item.accept(this) + "</ul>\n";
    }

    @Override
    public String printProduct(Product product) {
        return String.format(
                """
                        <li>
                        <p>Product</p>
                        <ul>
                        <li>Name: %s</li>
                        <li>Weight: %.2f Kg</li>
                        <li>Price: R$ %.2f</li>
                        </ul>
                        </li>
                        """, product.getName(), product.getWeight(), product.getPrice()
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
        StringBuilder output = new StringBuilder();

        output.append("{\"type\": \"Box\", \"boxes\": [");

        for (Box box : pallet.getBoxes()) {
            output.append(box.accept(this));
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
