package com.rdfgroup.selenium.unit.views.byJava;

import java.io.IOException;

import com.jt.selenium.SeleniumJT;
import com.jt.selenium.page.PageObject;
import com.rdfgroup.selenium.unit.views.composite.CoreTestsPageComposite;

public class CoreTestsPageByJava extends PageObject
{

	public CoreTestsPageByJava(SeleniumJT test) {
		super(test);
	}

	public void gotoCorePage() throws IOException {
		new CoreTestsPageComposite().gotoCorePage(test);
	}
	
	public void verifyCoreTests() throws IOException {

		new CoreTestsPageComposite().verifyCoreTests(test);
		
		
	}

}
