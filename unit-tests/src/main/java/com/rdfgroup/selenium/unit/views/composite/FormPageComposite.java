package com.rdfgroup.selenium.unit.views.composite;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jt.selenium.SeleniumJT;

public class FormPageComposite 
{

	private static final String SEX = "male";
	private static final String SEX2 = "female";
	private static final String VEHICLE = "vehicle1";
	private static final String EMAIL = "email";
	private static final String TEST_TEST_COM = "test@test.com";

	@Test
	public void goTo(SeleniumJT test) throws IOException {
		test.open("/selenium/page/form");
		test.verifyElementText("ht", "Form Tests");
	}

	@Test
	public void validateFormElements(SeleniumJT test) throws IOException {
		test.type(EMAIL, TEST_TEST_COM);
		test.verifyInputValue(EMAIL, TEST_TEST_COM);
		test.verifyInputValue(EMAIL, TEST_TEST_COM, "with custom message");
		
		String inputValue = test.getInputValue(EMAIL);
		Assert.assertEquals(inputValue, TEST_TEST_COM);
		
		test.click(SEX);
		test.verifyChecked(SEX);
		test.click(SEX2);
		test.verifyChecked(SEX2);
		test.verifyNotChecked(SEX);
		
		test.check(VEHICLE);
		test.verifyChecked(VEHICLE);
		
		test.uncheck(VEHICLE);
		test.verifyNotChecked(VEHICLE);
		
		test.select("cars", "saab");
		test.verifySelectedLabel("cars", "Saab");
		test.verifySelectedLabelContains("cars", "Sa");
		test.type("css=textarea", "Here are my details");
		
		test.typeHidden("iamhidden", "new value");
		
		Assert.assertEquals("new value", test.getValue("iamhidden"));
		
		test.selectAndWait("reload", "reloadoption");

		test.focus("focus");
		test.verifyElementText("fireeventresult", "focused");
		test.blur("focus");
		test.verifyElementText("fireeventresult", "blurred");
		
		test.pause(2000);
		
		test.dragAndDropWithPause("draggable", "droppable", 1000);
		
		test.verifyElementText("amidropped", "Dropped!");
		
		test.dragAndDropToObject("draggable2", "droppable2");
		
		test.verifyElementText("amidropped2", "Dropped!");
		
		test.pause(1000);
		
	}


}
