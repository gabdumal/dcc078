/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.customer.agent;

import assignments.customer.request.Question;
import assignments.customer.request.Request;
import assignments.customer.request.UpdateInformation;

public class Attendant
        extends Agent {

    public Attendant(Agent superiorAgent) {
        this.requestsList.add(Question.getQuestion());
        this.requestsList.add(UpdateInformation.getUpdateInformation());
        this.setSuperiorAgent(superiorAgent);
    }

    @Override
    protected String getRole() {
        return "Atendente";
    }

    protected String respond(Request request) {
        if (request.getType() == Question.getQuestion()) {
            if (request.getDescription().startsWith("[COMPLEXA]")) {
                if (request.getOrganization() != null) {
                    return "A resposta da empresa "
                            + request.getOrganization().getName() + " é:\n"
                            + request.getOrganization().receiveQuestion(request.getDescription());
                } else {
                    return "A resposta da gerência da central de atendimento é a seguinte:\n[Responde à questão].";
                }
            }
            return "[Responde à questão].";
        }

        else if (request.getType() == UpdateInformation.getUpdateInformation()) {
            return "Seu cadastro foi atualizado.";
        }

        else {
            return Agent.getNonAttendedResponse();
        }
    }

}
