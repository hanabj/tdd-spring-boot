package com.hanselnpetal.service;


import com.hanselnpetal.domain.Customer;
import com.hanselnpetal.domain.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ContactsManagementServiceIntegrationTestHana {

	@Autowired
	ContactsManagementService contactsManagementService;

	@Test
	public void testAddContactHappyPath() {
		CustomerContact contact = new CustomerContact();
		contact.setFirstName("hana");

		CustomerContact outputContact=contactsManagementService.add(contact);
		assertEquals("hana", outputContact.getFirstName());

	}
}
