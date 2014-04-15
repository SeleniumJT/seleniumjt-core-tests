package com.rdfgroup.selenium.unit.views.byJava;

import java.io.IOException;

import com.jt.selenium.SeleniumJT;
import com.jt.selenium.page.PageObject;
import com.rdfgroup.selenium.unit.views.composite.FormPageComposite;

public class FormPageByJava extends PageObject
{

	public FormPageByJava(SeleniumJT test) {
		super(test);
	}

	public void goTo() throws IOException {
		new FormPageComposite().goTo(test);
	}

	public void validateFormElements() throws IOException {
		new FormPageComposite().validateFormElements(test);
		
	}


}
