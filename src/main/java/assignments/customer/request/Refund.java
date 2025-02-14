/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.customer.request;

public class Refund
        implements RequestType {

    private static final Refund refund = new Refund();

    private Refund() {
    }

    public static Refund getRefund() {
        return refund;
    }

}
