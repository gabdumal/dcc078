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

import java.util.stream.Collectors;

public class HTMLExporter
        implements InventoryVisitor {

    @Override
    public String printProduct(Product product) {
        return String.format(
                """
                        <li>
                        <p>Produto</p>
                        <ul>
                        <li>Nome: %s</li>
                        <li>Peso: %.2f Kg</li>
                        <li>Preço: R$ %.2f</li>
                        </ul>
                        </li>
                        """, product.getName(), product.getWeight(), product.getPrice()
        );
    }

    @Override
    public String printBox(Box box) {
        return String.format(
                """
                        <li>
                        <p>Caixa</p>
                        <ul>
                        <li>Cor: %s</li>
                        <li>Produtos:%s</li>
                        </ul>
                        </li>
                        """,
                box.getColor(),
                box.getProducts()
                   .stream()
                   .map(this::print)
                   .collect(Collectors.joining())
        );
    }

    public String print(InventoryItem item) {
        return "<ul>\n" + item.accept(this) + "</ul>\n";
    }

    @Override
    public String printPallet(Pallet pallet) {
        return String.format(
                """
                        <li>
                        <p>Pallet</p>
                        <ul>
                        <li>Caixas:%s</li>
                        </ul>
                        </li>
                        """,
                pallet.getBoxes()
                      .stream()
                      .map(this::print)
                      .collect(Collectors.joining())
        );
    }

}
