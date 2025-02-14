/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.customer;

import assignments.customer.agent.Attendant;
import assignments.customer.agent.Chatbot;
import assignments.customer.agent.Technician;
import assignments.customer.organization.HomeAppliancesManufacturer;
import assignments.customer.organization.ServiceProvider;
import assignments.customer.organization.SoftwareVendor;
import assignments.customer.request.Complaint;
import assignments.customer.request.Request;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MediatorTest {

    private Chatbot    chatbot;
    private Attendant  attendant;
    private Technician technician;

    private HomeAppliancesManufacturer homeAppliancesManufacturer;
    private ServiceProvider            serviceProvider;
    private SoftwareVendor             softwareVendor;

    @BeforeEach
    public void setUp() {
        this.technician = new Technician(null);
        this.attendant  = new Attendant(this.technician);
        this.chatbot    = new Chatbot(this.attendant);

        this.homeAppliancesManufacturer = new HomeAppliancesManufacturer("Eletro-casa");
        this.serviceProvider            = new ServiceProvider("Limpa-tudo");
        this.softwareVendor             = new SoftwareVendor("Tecno-lebre");
    }

    /* HomeAppliancesManufacturer */

    @Test
    public void homeAppliancesManufacturerReceivesComplaint() {
        var request = new Request(
                Complaint.getComplaint(),
                "Os produtos são menores que aparentam ser no anúncio.",
                homeAppliancesManufacturer
        );
        var response = this.chatbot.respond(request);
        assertEquals(
                """
                        Sua reclamação foi registrada.
                        A resposta da empresa é:
                        Nós, da empresa Eletro-casa eletrodomésticos, procuraremos melhorar nossos processos para evitar demais transtornos.""",
                response
        );
    }

}
