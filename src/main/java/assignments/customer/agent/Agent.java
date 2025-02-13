/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.customer.agent;

import assignments.customer.request.Request;
import assignments.customer.request.RequestType;

import java.util.ArrayList;

public abstract class Agent {

    protected ArrayList<RequestType> requestsList = new ArrayList<RequestType>();
    private   Agent                  superiorAgent;

    protected Agent() {
    }

    protected static String getNonAttendedResponse() {
        return "Esta requisição não pode ser atendida!";
    }

    protected Agent getSuperiorAgent() {
        return superiorAgent;
    }

    protected void setSuperiorAgent(Agent superiorAgent) {
        this.superiorAgent = superiorAgent;
    }

    public String handleRequest(Request request) {
        if (this.requestsList.contains(request.getType())) {
            return this.respond(request);
        }
        else {
            if (this.superiorAgent != null) {
                return this.superiorAgent.handleRequest(request);
            }
            else {
                return Agent.getNonAttendedResponse();
            }
        }
    }

    protected abstract String respond(Request request);

}
