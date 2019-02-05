package com.hanselnpetal;


import com.hanselnpetal.controller.ContactsManagementControllerIntegrationTestHana;
import com.hanselnpetal.data.repos.CustomerContactRepositoryIntegrationTest;

import com.hanselnpetal.service.ContactsManagementServiceIntegrationTestHana;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses ({ ContactsManagementServiceIntegrationTestHana.class,
	ContactsManagementControllerIntegrationTestHana.class, CustomerContactRepositoryIntegrationTest.class })
public class AddContactFeatureTestSuite {

	// intentionally empty - Test Suite Setup (annotations) is sufficient
}
