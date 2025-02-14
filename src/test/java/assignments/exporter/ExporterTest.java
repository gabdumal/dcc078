/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.exporter;

import assignments.exporter.InventoryItem.Box;
import assignments.exporter.InventoryItem.Pallet;
import assignments.exporter.InventoryItem.Product;
import assignments.exporter.InventoryVisitor.CSVExporter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExporterTest {

    private final Product smartphone  = new Product("Smartphone", 0.2d, 800d);
    private final Product laptop      = new Product("Laptop", 2.5d, 3600d);
    private final Product printer     = new Product("Impressora", 4.2d, 2100d);
    private final Product keyboard    = new Product("Teclado", 0.7d, 470d);
    private final Product webcam      = new Product("Câmera", 0.1d, 300d);
    private final Box     smallBox    = new Box(new ArrayList<Product>(List.of(smartphone, webcam)));
    private final Box     mediumBox   = new Box(new ArrayList<Product>(List.of(laptop, keyboard)));
    private final Pallet  largePallet = new Pallet(new ArrayList<Box>(List.of(smallBox, mediumBox)));
    private final Box     largeBox    = new Box(new ArrayList<Product>(List.of(printer)));
    private final Pallet  smallPallet = new Pallet(new ArrayList<Box>(List.of(largeBox)));

    /* CSV */

    @Test
    public void shouldExportProductAsCSV() {
        CSVExporter csvExporter = new CSVExporter();
        var         exported    = csvExporter.printProduct(smartphone);
        assertEquals(
                """
                        Tipo,Nome,Peso,Preço
                        Product,Smartphone,0.20,800.00
                        """, exported
        );
    }

}
