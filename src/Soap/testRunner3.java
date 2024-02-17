package Soap;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class testRunner3 {
	
	@Test
	public void singleTest() throws XmlException, IOException, SoapUIException {
		// Grab the project
		WsdlProject project= new WsdlProject("C:\\Users\\HP\\Documents\\SoapUI Test Automation Course\\EmployeeSoapService.xml");
		
		// Grab the test suite in the project
		WsdlTestSuite testSuite = project.getTestSuiteByName("Testing");
		
		WsdlTestCase testCase = testSuite.getTestCaseByName("GetEmployee");
		
		// Run the test cases
		TestRunner runner=testCase.run(new PropertiesMap(), false); // for setting property from java test set it here
		Assert.assertEquals(String.valueOf(Status.FINISHED), String.valueOf(runner.getStatus()));
		
	}

}
