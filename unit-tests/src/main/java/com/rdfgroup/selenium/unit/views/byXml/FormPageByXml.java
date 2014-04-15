package com.rdfgroup.selenium.unit.views.byXml;

import java.io.IOException;

import org.testng.annotations.Test;

import com.jt.selenium.testng.SeleniumTestNgPageObject;
import com.rdfgroup.selenium.unit.views.composite.FormPageComposite;

public class FormPageByXml extends SeleniumTestNgPageObject {

	@Test
	public void goTo() throws IOException {
		new FormPageComposite().goTo(test);
	}

	@Test
	public void validateFormElements() throws IOException {
		new FormPageComposite().validateFormElements(test);
	}

}
