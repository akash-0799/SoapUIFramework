package Rest;

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

public class restRunner2 {
	@Test // Runs all the tests from test suite and we are treating them as a single test case
	public void RestTest2() throws XmlException, IOException, SoapUIException {
		// Grab the project
		WsdlProject project= new WsdlProject("C:\\Users\\HP\\Documents\\SoapUI Test Automation Course\\LibraryAPI-project.xml");
		
		// Grab the test suite in the project
		for(int j=0;j<project.getTestSuiteCount(); j++) {
			WsdlTestSuite testSuite = project.getTestSuiteAt(j);
			
			// Grab the test cases present in the testsuite
			for(int i=0;i<testSuite.getTestCaseCount();i++) {
				WsdlTestCase testCase = testSuite.getTestCaseAt(i);		
			// Run the test cases
				TestRunner runner=testCase.run(new PropertiesMap(), false); // for setting property from java test set it here
				
				Assert.assertEquals(String.valueOf(Status.FINISHED), String.valueOf(runner.getStatus()));
				
				}
			
		}
		
		

}
	
}

