/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.customer.request;

import assignments.customer.organization.Organization;

public class Request {

    private final String       description;
    private final RequestType  requestType;
    private final Organization organization;
    public Request(
            RequestType requestType,
            String description,
            Organization organization
    ) {
        this.requestType  = requestType;
        this.description  = description;
        this.organization = organization;
    }

    public String getDescription() {
        return description;
    }

    public Organization getOrganization() {
        return organization;
    }

    public RequestType getType() {
        return requestType;
    }

}
