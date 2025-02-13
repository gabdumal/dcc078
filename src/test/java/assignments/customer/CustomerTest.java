/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.customer;

import assignments.customer.agent.Attendant;
import assignments.customer.agent.Chatbot;
import assignments.customer.agent.Technician;
import assignments.customer.request.Complaint;
import assignments.customer.request.Request;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    private Chatbot    chatbot;
    private Attendant  attendant;
    private Technician technician;

    @BeforeEach
    public void setUp() {
        this.technician = new Technician(null);
        this.attendant  = new Attendant(this.technician);
        this.chatbot    = new Chatbot(this.attendant);
    }

    @Test
    public void chatbotShouldAttendComplaint() {
        var request  = new Request(Complaint.getComplaint(), "Os produtos são menores que aparentam ser no anúncio.");
        var response = this.chatbot.respond(request);
        assertEquals("Your complaint has been registered.", response);
    }

}
