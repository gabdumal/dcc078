/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.customer;

public abstract class SupportHandler {

    protected String         name;
    protected int            level;
    protected SupportHandler nextHandler;

    public SupportHandler(
            String name,
            int level
    ) {
        this.name  = name;
        this.level = level;
    }

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

}
