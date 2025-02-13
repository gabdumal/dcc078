/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.customer.request;

public class Request {

    private final String      description;
    private       RequestType requestType;

    public Request(
            RequestType requestType,
            String description
    ) {
        this.requestType = requestType;
        this.description = description;
    }

    public RequestType getType() {
        return requestType;
    }

    public void setType(RequestType requestType) {
        this.requestType = requestType;
    }

}
