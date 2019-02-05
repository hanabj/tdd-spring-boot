package com.hanselnpetal.controller;


import com.hanselnpetal.domain.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactsManagementControllerIntegrationTestHana {

	@Autowired
	ContactsManagementController contactsManagementController;

	
	@Test
	public void testAddContactHappyPath() {
		CustomerContact contact= new CustomerContact();
		contact.setFirstName("hana");

		String output=contactsManagementController.processAddContactSubmit(contact);
		assertThat(output, is(equalTo("/addContactForm")));

	}
	
	@Test
	public void testAddContactFirstNameMissing() {
		CustomerContact contact= new CustomerContact();


		String output=contactsManagementController.processAddContactSubmit(contact);
		assertThat(output, is(equalTo("redirect:/showAddContact")));
		
	}
}
