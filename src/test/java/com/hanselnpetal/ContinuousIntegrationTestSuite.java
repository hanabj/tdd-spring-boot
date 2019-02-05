package com.hanselnpetal;


import com.hanselnpetal.controller.ContactsManagementControllerIntegrationTestHana;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses ({ DatastoreSystemsHealthTest.class, 
	ContactsManagementControllerIntegrationTestHana.class })

public class ContinuousIntegrationTestSuite {

	// intentionally empty - Test Suite Setup (annotations) is sufficient
}
