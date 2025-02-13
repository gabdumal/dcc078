/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.customer;

import assignments.customer.agent.Attendant;
import assignments.customer.agent.Chatbot;
import assignments.customer.agent.Technician;
import assignments.customer.request.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChainOfResponsibilityTest {

    private Chatbot    chatbot;
    private Attendant  attendant;
    private Technician technician;

    @BeforeEach
    public void setUp() {
        this.technician = new Technician(null);
        this.attendant  = new Attendant(this.technician);
        this.chatbot    = new Chatbot(this.attendant);
    }

    /* Chatbot */

    @Test
    public void chatbotShouldAttendComplaint() {
        var request  = new Request(Complaint.getComplaint(), "Os produtos são menores que aparentam ser no anúncio.");
        var response = this.chatbot.respond(request);
        assertEquals("Sua reclamação foi registrada.", response);
    }

    @Test
    public void chatbotShouldNotAttendQuestion() {
        var request  = new Request(Question.getQuestion(), "Como eu ativo o modo silencioso do micro-ondas?");
        var response = this.chatbot.respond(request);
        assertEquals("Esta requisição não pode ser atendida!", response);
    }

    @Test
    public void chatbotShouldNotAttendUpdateInformation() {
        var request = new Request(
                UpdateInformation.getUpdateInformation(),
                "Gostaria de atualizar meu número de telefone para (12)98765-4321."
        );
        var response = this.chatbot.respond(request);
        assertEquals("Esta requisição não pode ser atendida!", response);
    }

    @Test
    public void chatbotShouldNotAttendMalfunctioning() {
        var request = new Request(
                Malfunctioning.getMalfunctioning(),
                "A trempe na parte traseira esquerda do meu fogão não está acendendo."
        );
        var response = this.chatbot.respond(request);
        assertEquals("Esta requisição não pode ser atendida!", response);
    }

    @Test
    public void chatbotShouldNotAttendReplacement() {
        var request = new Request(
                Replacement.getReplacement(),
                "O laptop que foi entregue é de um modelo diferente daquele que eu pedi. Gostaria " +
                "de solicitar a troca pelo correto."
        );
        var response = this.chatbot.respond(request);
        assertEquals("Esta requisição não pode ser atendida!", response);
    }

    /* Attendant */

    @Test
    public void attendantShouldNotAttendComplaint() {
        var request  = new Request(Complaint.getComplaint(), "Os produtos são menores que aparentam ser no anúncio.");
        var response = this.attendant.respond(request);
        assertEquals("Esta requisição não pode ser atendida!", response);
    }

    @Test
    public void attendantShouldAttendQuestion() {
        var request  = new Request(Question.getQuestion(), "Como eu ativo o modo silencioso do micro-ondas?");
        var response = this.attendant.respond(request);
        assertEquals("[Responde à questão].", response);
    }

    @Test
    public void attendantShouldAttendUpdateInformation() {
        var request = new Request(
                UpdateInformation.getUpdateInformation(),
                "Gostaria de atualizar meu número de telefone para (12)98765-4321."
        );
        var response = this.attendant.respond(request);
        assertEquals("Seu cadastro foi atualizado.", response);
    }

    @Test
    public void attendantShouldNotAttendMalfunctioning() {
        var request = new Request(
                Malfunctioning.getMalfunctioning(),
                "A trempe na parte traseira esquerda do meu fogão não está acendendo."
        );
        var response = this.attendant.respond(request);
        assertEquals("Esta requisição não pode ser atendida!", response);
    }

    @Test
    public void attendantShouldNotAttendReplacement() {
        var request = new Request(
                Replacement.getReplacement(),
                "O laptop que foi entregue é de um modelo diferente daquele que eu pedi. Gostaria " +
                "de solicitar a troca pelo correto."
        );
        var response = this.attendant.respond(request);
        assertEquals("Esta requisição não pode ser atendida!", response);
    }

    /* Technician */

    @Test
    public void technicianShouldNotAttendComplaint() {
        var request  = new Request(Complaint.getComplaint(), "Os produtos são menores que aparentam ser no anúncio.");
        var response = this.technician.respond(request);
        assertEquals("Esta requisição não pode ser atendida!", response);
    }

    @Test
    public void technicianShouldNotAttendQuestion() {
        var request  = new Request(Question.getQuestion(), "Como eu ativo o modo silencioso do micro-ondas?");
        var response = this.technician.respond(request);
        assertEquals("Esta requisição não pode ser atendida!", response);
    }

    @Test
    public void technicianShouldNotAttendUpdateInformation() {
        var request = new Request(
                UpdateInformation.getUpdateInformation(),
                "Gostaria de atualizar meu número de telefone para (12)98765-4321."
        );
        var response = this.technician.respond(request);
        assertEquals("Esta requisição não pode ser atendida!", response);
    }

    @Test
    public void technicianShouldAttendMalfunctioning() {
        var request = new Request(
                Malfunctioning.getMalfunctioning(),
                "A trempe na parte traseira esquerda do meu fogão não está acendendo."
        );
        var response = this.technician.respond(request);
        assertEquals("[Responde a como corrigir o problema de funcionamento].", response);
    }

    @Test
    public void technicianShouldAttendReplacement() {
        var request = new Request(
                Replacement.getReplacement(),
                "O laptop que foi entregue é de um modelo diferente daquele que eu pedi. Gostaria " +
                "de solicitar a troca pelo correto."
        );
        var response = this.technician.respond(request);
        assertEquals("Sua substituição foi [aprovada/rejeitada].", response);
    }

}
