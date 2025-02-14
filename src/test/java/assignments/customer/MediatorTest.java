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
import assignments.customer.request.Malfunctioning;
import assignments.customer.request.Question;
import assignments.customer.request.Request;
import assignments.customer.request.UpdateInformation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MediatorTest {

    private Chatbot chatbot;
    private Attendant attendant;
    private Technician technician;

    private HomeAppliancesManufacturer homeAppliancesManufacturer;
    private ServiceProvider serviceProvider;
    private SoftwareVendor softwareVendor;

    @BeforeEach
    public void setUp() {
        this.technician = new Technician(null);
        this.attendant = new Attendant(this.technician);
        this.chatbot = new Chatbot(this.attendant);

        this.homeAppliancesManufacturer = new HomeAppliancesManufacturer("Eletro-casa");
        this.serviceProvider = new ServiceProvider("Limpa-tudo");
        this.softwareVendor = new SoftwareVendor("Tecno-lebre");
    }

    /* Complaint */

    @Test
    public void centralReceivesComplaint() {
        var request = new Request(
                Complaint.getComplaint(),
                "Os prazos de atendimento estão muito demorados.",
                null);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Chatbot: Sua reclamação foi registrada.""",
                response);
    }

    @Test
    public void homeAppliancesManufacturerReceivesComplaint() {
        var request = new Request(
                Complaint.getComplaint(),
                "Os produtos são menores que aparentam ser no anúncio.",
                homeAppliancesManufacturer);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Chatbot: Sua reclamação foi registrada.
                        A resposta da empresa é:
                        Nós, da empresa Eletro-casa eletrodomésticos, procuraremos melhorar nossos processos para evitar demais transtornos.""",
                response);
    }

    @Test
    public void serviceProviderReceivesComplaint() {
        var request = new Request(
                Complaint.getComplaint(),
                "A parte de trás do sofá não foi limpa.",
                serviceProvider);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Chatbot: Sua reclamação foi registrada.
                        A resposta da empresa é:
                        Nós, da empresa Limpa-tudo, procuraremos melhorar nosso serviço, para evitar que a situação se repita.""",
                response);
    }

    @Test
    public void softwareVendorReceivesComplaint() {
        var request = new Request(
                Complaint.getComplaint(),
                "O sistema de caixa não agrupa produtos iguais no mesmo item.",
                softwareVendor);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Chatbot: Sua reclamação foi registrada.
                        A resposta da empresa é:
                        Nós, da empresa Tecno-lebre software, procuraremos melhorar nossos sistemas, a fim de solucionar seu problema.""",
                response);
    }

    /* Question */

    @Test
    public void centralReceivesSimpleQuestion() {
        var request = new Request(
                Question.getQuestion(),
                "Qual é o horário de atendimento?",
                null);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Atendente: [Responde à questão].""",
                response);
    }

    @Test
    public void centralReceivesComplexQuestion() {
        var request = new Request(
                Question.getQuestion(),
                "[COMPLEXA]",
                null);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Atendente: A resposta da gerência da central de atendimento é a seguinte:
                        [Responde à questão].""",
                response);
    }

    @Test
    public void homeAppliancesManufacturerReceivesSimpleQuestion() {
        var request = new Request(
                Question.getQuestion(),
                "Gostaria de receber o manual do Liquidificador modelo XH-89.",
                homeAppliancesManufacturer);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Atendente: [Responde à questão].""",
                response);
    }

    @Test
    public void homeAppliancesManufacturerReceivesComplexQuestion() {
        var request = new Request(
                Question.getQuestion(),
                "[COMPLEXA]",
                homeAppliancesManufacturer);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Atendente: A resposta da empresa Eletro-casa é:
                        [Responde à questão].""",
                response);
    }

    @Test
    public void serviceProviderReceivesSimpleQuestion() {
        var request = new Request(
                Question.getQuestion(),
                "Qual é o valor da limpeza de carros noturna?",
                serviceProvider);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Atendente: [Responde à questão].""",
                response);
    }

    @Test
    public void serviceProviderReceivesComplexQuestion() {
        var request = new Request(
                Question.getQuestion(),
                "[COMPLEXA]",
                serviceProvider);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Atendente: A resposta da empresa Limpa-tudo é:
                        [Responde à questão].""",
                response);
    }

    @Test
    public void softwareVendorReceivesSimpleQuestion() {
        var request = new Request(
                Question.getQuestion(),
                "Como eu acesso a seção de notificações?",
                softwareVendor);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Atendente: [Responde à questão].""",
                response);
    }

    @Test
    public void softwareVendorReceivesComplexQuestion() {
        var request = new Request(
                Question.getQuestion(),
                "[COMPLEXA]",
                softwareVendor);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Atendente: A resposta da empresa Tecno-lebre é:
                        [Responde à questão].""",
                response);
    }

    /* UpdateInformation */

    @Test
    public void centralReceivesUpdateInformationRequest() {
        var request = new Request(
                UpdateInformation.getUpdateInformation(),
                "Gostaria de atualizar meu telefone para (12) 98765-4321.",
                null);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Atendente: Seu cadastro foi atualizado.""",
                response);
    }

    @Test
    public void homeAppliancesManufacturerReceivesUpdateInformationRequest() {
        var request = new Request(
                UpdateInformation.getUpdateInformation(),
                "Gostaria de me registrar a garantia do meu forno. Seguem as informações: [INFORMAÇÕES].",
                homeAppliancesManufacturer);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Atendente: Seu cadastro foi atualizado.""",
                response);
    }

    @Test
    public void serviceProviderReceivesUpdateInformationRequest() {
        var request = new Request(
                UpdateInformation.getUpdateInformation(),
                "Gostaria de atualizar meu endereço para Rua das Flores, 123, Boas Novas.",
                serviceProvider);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Atendente: Seu cadastro foi atualizado.""",
                response);
    }

    @Test
    public void softwareVendorReceivesUpdateInformationRequest() {
        var request = new Request(
                UpdateInformation.getUpdateInformation(),
                "Gostaria de atualizar minha senha para 123456.",
                softwareVendor);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Atendente: Seu cadastro foi atualizado.""",
                response);
    }

    /* Malfunctioning */

    @Test
    public void centralReceivesSimpleMalfunctioningComplaint() {
        var request = new Request(
                Malfunctioning.getMalfunctioning(),
                "A URA não reconhece minha voz.",
                null);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Técnico: [Responde a como corrigir o problema de funcionamento].""",
                response);
    }

    @Test
    public void centralReceivesComplexMalfunctioningComplaint() {
        var request = new Request(
                Malfunctioning.getMalfunctioning(),
                "[COMPLEXO]",
                null);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Técnico: O suporte técnico da nossa central de atendimento responde o seguinte:
                        [Responde a como corrigir o problema de funcionamento].""",
                response);
    }

    @Test
    public void homeAppliancesManufacturerReceivesSimpleMalfunctioningComplaint() {
        var request = new Request(
                Malfunctioning.getMalfunctioning(),
                "A trempe traseira na esquerda do fogão não acende.",
                homeAppliancesManufacturer);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Técnico: [Responde a como corrigir o problema de funcionamento].""",
                response);
    }

    @Test
    public void homeAppliancesManufacturerReceivesComplexMalfunctioningComplaint() {
        var request = new Request(
                Malfunctioning.getMalfunctioning(),
                "[COMPLEXO].",
                homeAppliancesManufacturer);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Técnico: O suporte técnico da empresa Eletro-casa responde o seguinte:
                        [Responde à questão].""",
                response);
    }

    @Test
    public void serviceProviderReceivesSimpleMalfunctioningComplaint() {
        var request = new Request(
                Malfunctioning.getMalfunctioning(),
                "A trempe traseira na esquerda do fogão não acende.",
                serviceProvider);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Técnico: [Responde a como corrigir o problema de funcionamento].""",
                response);
    }

    @Test
    public void serviceProviderReceivesComplexMalfunctioningComplaint() {
        var request = new Request(
                Malfunctioning.getMalfunctioning(),
                "[COMPLEXO].",
                serviceProvider);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Técnico: O suporte técnico da empresa Limpa-tudo responde o seguinte:
                        [Responde à questão].""",
                response);
    }

    @Test
    public void softwareVendorReceivesSimpleMalfunctioningComplaint() {
        var request = new Request(
                Malfunctioning.getMalfunctioning(),
                "A trempe traseira na esquerda do fogão não acende.",
                softwareVendor);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Técnico: [Responde a como corrigir o problema de funcionamento].""",
                response);
    }

    @Test
    public void softwareVendorReceivesComplexMalfunctioningComplaint() {
        var request = new Request(
                Malfunctioning.getMalfunctioning(),
                "[COMPLEXO].",
                softwareVendor);
        var response = this.chatbot.handleRequest(request);
        assertEquals(
                """
                        Técnico: O suporte técnico da empresa Tecno-lebre responde o seguinte:
                        [Responde à questão].""",
                response);
    }

}
