package com.hanselnpetal.controller;


import com.hanselnpetal.domain.CustomerContact;
import com.hanselnpetal.service.ContactsManagementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ContactsManagementController.class)
public class ContactsManagementControllerUnitTestHana {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ContactsManagementService contactsManagementService;

    @InjectMocks
    ContactsManagementController contactsManagementController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testAddContactHappyPath() throws Exception {

        CustomerContact aMockContact = new CustomerContact();
        aMockContact.setFirstName("Hana");

        when(contactsManagementService.add(any(CustomerContact.class))).thenReturn(aMockContact);

        CustomerContact postContact = new CustomerContact();
        postContact.setFirstName("Chiheb");
        mockMvc.perform(post("/addContact", postContact))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void testAddContactBizServiceRuleNotSatisfied() throws Exception {
        // setup a mock response of NULL object returned from the mock service componen


        when(contactsManagementService.add(any(CustomerContact.class))).thenReturn(null);

        CustomerContact postContact = new CustomerContact();
        postContact.setFirstName("Chiheb");
        mockMvc.perform(post("/addContact", postContact))
                .andExpect(status().is(302))
                .andReturn();
    }

    @Test
    public void testAddContactOccasionHappyPath() throws Exception {
        // implement this
    }
}
