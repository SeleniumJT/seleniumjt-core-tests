package com.rdfgroup.selenium.unit.views.byXml;

import java.io.IOException;

import org.testng.annotations.Test;

import com.jt.selenium.testng.SeleniumTestNgPageObject;
import com.rdfgroup.selenium.unit.views.composite.CoreTestsPageComposite;

public class CoreTestsPageByXml extends SeleniumTestNgPageObject
{
	@Test
	public void gotoCorePage() throws IOException {
		new CoreTestsPageComposite().gotoCorePage(test);
	}
	
	@Test
	public void verifyCoreTests() throws IOException {

		new CoreTestsPageComposite().verifyCoreTests(test);
		
	}

}
