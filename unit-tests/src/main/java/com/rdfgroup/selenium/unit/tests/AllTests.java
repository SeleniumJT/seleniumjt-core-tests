package com.rdfgroup.selenium.unit.tests;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jt.selenium.testng.SeleniumTestNG;
import com.rdfgroup.selenium.unit.views.byJava.AHrefLinksPageByJava;
import com.rdfgroup.selenium.unit.views.byJava.CoreTestsPageByJava;
import com.rdfgroup.selenium.unit.views.byJava.FormPageByJava;

public class AllTests extends SeleniumTestNG
{

	@Test
	public void testAllSeleniumCore() throws IOException
	{
		CoreTestsPageByJava coreTestsPage = new CoreTestsPageByJava(test);
		coreTestsPage.gotoCorePage();
		coreTestsPage.verifyCoreTests();
	}

	@Test
	public void testAllSeleniumLinks() throws IOException
	{
		
		AHrefLinksPageByJava aHrefLinksPage = new AHrefLinksPageByJava(test);
		aHrefLinksPage.gotoLinksPage();
		aHrefLinksPage.verifyAllLinksWork();
	}

	@Test
	@Parameters("title")
	public void testAllSeleniumForm(String title) throws IOException
	{
	
		FormPageByJava formPage = new FormPageByJava(test);
		formPage.goTo();
		formPage.validateFormElements();
		System.out.println("#### parameter ##### "+title);
	}


}
