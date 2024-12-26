/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package structural_patterns.decorator;

public interface Meal {

    double getPrice();

    String getItems();

    default int getAmountOfMeal(Class<?> mealClass) {
        if (mealClass.isInstance(this)) {
            return 1;
        }
        else {
            return 0;
        }
    }

}