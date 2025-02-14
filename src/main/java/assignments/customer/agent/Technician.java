/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.customer.agent;

import assignments.customer.request.Malfunctioning;
import assignments.customer.request.Refund;
import assignments.customer.request.Request;

public class Technician
        extends Agent {

    public Technician(Agent superiorAgent) {
        this.requestsList.add(Malfunctioning.getMalfunctioning());
        this.requestsList.add(Refund.getRefund());
        this.setSuperiorAgent(superiorAgent);
    }

    @Override
    protected String getRole() {
        return "Técnico";
    }

    public String respond(Request request) {

        if (request.getType() == Malfunctioning.getMalfunctioning()) {
            if (request.getDescription().startsWith("[COMPLEXO]")) {
                if (request.getOrganization() != null) {
                    return "O suporte técnico da empresa "
                            + request.getOrganization().getName() + " responde o seguinte:\n"
                            + request.getOrganization().receiveQuestion(request.getDescription());
                } else {
                    return "O suporte técnico da nossa central de atendimento responde o seguinte:\n[Responde a como corrigir o problema de funcionamento].";
                }
            }
            return "[Responde a como corrigir o problema de funcionamento].";
        } else if (request.getType() == Refund.getRefund()) {
            return "Seu reembolso foi [aprovado/rejeitado].";
        } else {
            return Agent.getNonAttendedResponse();
        }
    }

}
