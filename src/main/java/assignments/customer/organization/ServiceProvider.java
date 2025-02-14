/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.customer.organization;

public class ServiceProvider
        implements Organization {

    private final String name;

    public ServiceProvider(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String receiveComplaint(String complaint) {
        return "Nós, da empresa " + this.getName() + ", procuraremos melhorar nosso serviço, para evitar que a " +
               "situação se " + "repita.";
    }

    @Override
    public String receiveQuestion(String question) {
        return "";
    }

    @Override
    public String receiveRefundRequest(String description) {
        return "";
    }

}
