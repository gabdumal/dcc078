/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.customer.agent;

import assignments.customer.request.Malfunctioning;
import assignments.customer.request.Replacement;
import assignments.customer.request.Request;

public class Technician
        extends Agent {

    public Technician(Agent superiorAgent) {
        this.requestsList.add(Malfunctioning.getMalfunctioning());
        this.requestsList.add(Replacement.getReplacement());
        this.setSuperiorAgent(superiorAgent);
    }

    public String respond(Request request) {
        if (request.getType() == Malfunctioning.getMalfunctioning()) {
            return "[Answer how to solve the malfunctioning].";
        }
        else if (request.getType() == Replacement.getReplacement()) {
            return "Your replacement has been approved.";
        }
        else {
            return Agent.getNonAttendedResponse();
        }
    }

}
