package com.hanselnpetal.service;


import com.hanselnpetal.data.repos.CustomerContactRepository;
import com.hanselnpetal.domain.Customer;
import com.hanselnpetal.domain.CustomerContact;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ContactsManagementServiceUnitTestHana {

    @Mock
    CustomerContactRepository customerContactRepository;

    @InjectMocks
    ContactsManagementService contactsManagementService;

    @Before
    public void seTup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddContactHappyPath() {

        CustomerContact aMockContact = new CustomerContact();
        aMockContact.setFirstName("Hana");

        when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(aMockContact);

        CustomerContact testContact= new CustomerContact();
        testContact.setFirstName("test");
        CustomerContact test= contactsManagementService.add(testContact);

        assertEquals("Hana", test.getFirstName() );

    }
}
