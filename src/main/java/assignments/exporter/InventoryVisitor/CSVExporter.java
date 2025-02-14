/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.exporter.InventoryVisitor;

import assignments.exporter.InventoryItem.Box;
import assignments.exporter.InventoryItem.Pallet;
import assignments.exporter.InventoryItem.Product;

public class CSVExporter
        implements InventoryVisitor {

    @Override
    public String printProduct(Product product) {
        return this.printProductHeader() + "\n" + this.printProductLine(product);
    }

    private String printProductHeader() {
        return "Tipo,Nome,Peso,Preço";
    }

    private String printProductLine(Product product) {
        return String.format("Product,%s,%.2f,%.2f%n", product.getName(), product.getWeight(), product.getPrice());
    }

    @Override
    public String printBox(Box box) {
        return "";
    }

    @Override
    public String printPallet(Pallet pallet) {
        return "";
    }

}
