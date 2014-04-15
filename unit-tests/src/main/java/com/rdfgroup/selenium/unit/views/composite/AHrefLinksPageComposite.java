package com.rdfgroup.selenium.unit.views.composite;

import java.io.IOException;

import org.testng.annotations.Test;

import com.jt.selenium.SeleniumJT;

public class AHrefLinksPageComposite
{
	
	@Test
	public void gotoLinksPage(SeleniumJT test) throws IOException {
		test.open("/selenium");
		test.verifyElementText("divid", "Check divid text value");
		test.verifyElementTextNotEqualTo("divid", "This is wrong");
	}
	
	@Test
	public void verifyAllLinksWork(SeleniumJT test) throws IOException {
		test.clickAndWait("byId");
		test.verifyTextPresent("Success 2");
		gotoLinksPage(test);

		test.clickAndWait("css=button.myClass");
		test.verifyTextPresent("Success 2");
		gotoLinksPage(test);

		test.clickAndWait("link=ByLink");
		test.verifyTextPresent("Success 2");
		gotoLinksPage(test);

		test.clickAndWait("name=byName");
		test.verifyTextPresent("Success 2");
		gotoLinksPage(test);
		
		test.click("nexttest");
	}


}
