/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package creational_patterns.bridge.Model;

public class Sedan extends Model {

    public Sedan(double baseCost) {
        super(baseCost);
    }

    @Override
    public double calculateFinalCost() {
        return this.baseCost * (1 + this.engine.costIncreasePercentage());
    }

}
