/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.customer.agent;

import assignments.customer.request.Complaint;
import assignments.customer.request.Request;

public class Chatbot
        extends Agent {

    public Chatbot(Agent superiorAgent) {
        this.requestsList.add(Complaint.getComplaint());
        this.setSuperiorAgent(superiorAgent);
    }

    @Override
    protected String getRole() {
        return "Chatbot";
    }

    protected String respond(Request request) {
        if (request.getType() == Complaint.getComplaint()) {
            var response = "Sua reclamação foi registrada.";

            var organization = request.getOrganization();
            if (organization != null) {
                response += "\nA resposta da empresa é:\n" + organization.receiveComplaint(request.getDescription());
            }

            return response;
        } else {
            return Agent.getNonAttendedResponse();
        }
    }

}
