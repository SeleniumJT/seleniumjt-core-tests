package com.rdfgroup.selenium.unit.views.composite;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jt.selenium.SeleniumJT;

public class CoreTestsPageComposite 
{
	@Test
	public void gotoCorePage(SeleniumJT test) throws IOException {
		test.open("/selenium/page/core");
		System.out.println("l");
	}
	
	@Test
	public void verifyCoreTests(SeleniumJT test) throws IOException {

		titleChecks(test);
		
		test.screenShot("testScreenshot");
		
		test.verifyOccurrencesInElement("multitext", "ThisText", 5);
		int occurrences = test.getOccurrences("ThisText");
		
		Assert.assertEquals(occurrences, 5);
		
		String htmlSource = test.getHtmlSource();
		String data2 = test.data("multitext");
		Assert.assertTrue(htmlSource.contains(data2));
		
		// Test os JavaScript execution
		if (test.runningInIE()) {
			test.executeJavaScript("$('#multitext').html('injected');");
			test.verifyElementText("multitext", "injected");
		}
		else {
			test.executeJavaScript("alert('ok')");
			test.verifyAlert("ok");
		}

		hideAndShow(test);

		hideAndShowText(test);
		
		deleteElement(test);
		
		testCss(test);
		
		showImage(test);
		
		miscellaneousClicking(test);
		
		testLocalStorageCapabilities(test);
		
		test.runningInChrome();
		test.runningInFirefox();
		test.runningInIE();
		test.runningInSafari();
		
		test.screenShot("testScreenshot2");

		test.click("newbutton");
		test.click("newclick");
		
		
	}

	private void hideAndShowText(SeleniumJT test) {
		test.verifyElementPresent("target");
		// Test changing values
		test.verifyElementText("target", "This is the target to change");
		// Partial equality
		test.verifyElementContains("target", "target to change");
		test.click("changedivtext");
		test.verifyElementText("target", "Text has changed");
		// Exact equality
		test.verifyElementTextNotEqualTo("target", "This is the target to change");
		// Partial equality
		test.verifyElementNotContains("target", "target to change");
		
		// This will change the value after 2 seconds
		test.click("changedivtextpause");
		// Test that condition does not fail immediately but allows time for text to change
		test.verifyElementText("target", "Text has changed after pause");
		
		test.fireEvent("changedivtextfired", "click");
		test.verifyElementText("target", "Text has changed after firedevent");
		
		// This takes 2 seconds for text to appear
		test.click("createtext");
		// Test condition does not fail immediately
		test.waitForText("Text is here");
		
		test.verifyElementNotPresent("iAmNotHere");
		
		test.verifyTextNotPresent("No Text Here");
		
		test.click("changedivtextwait2");
		// There is a pause before wither of these conditions are met
		test.verifyTextPresent("You have been waiting for this 2");
		test.verifyTextPresent("You have been waiting for this 2", "some custom message");
		
		test.click("changedivtextwait");
		test.waitForElementText("target", test.data("waiting"));
	}

	private void hideAndShow(SeleniumJT test) {
		// Element is there but hidden
		test.verifyElementPresent("hiddendiv");
		test.verifyElementNotVisible("hiddendiv");
		
		// Click of button will make element visible after 2 seconds
		test.click("showhiddendiv");
		test.verifyElementNotVisible("hiddendiv");
		
		// Test that this condition is met
		test.waitForElementPresentAndVisible("hiddendiv");
		test.verifyElementVisible("hiddendiv");
		
		// Click of button will make element invisible after 2 seconds
		test.click("hidehiddendiv");
		test.waitForElementNotVisible("hiddendiv");
		test.verifyElementNotVisible("hiddendiv");
	}

	private void titleChecks(SeleniumJT test) {
		String flow = test.data("flow");
		if (flow !=null && flow.equals("flow1")) {
			test.waitForTitle("Title is core");

			String data = test.data("title");
			test.verifyTitle(data);
		}
		test.waitForTitleToContain("core");
	}

	private void deleteElement(SeleniumJT test) {
		test.click("deleteelement");
		test.waitForElementNotPresent("target");
		test.verifyElementNotPresent("target");
	}

	private void testCss(SeleniumJT test) {
		
		String attribute = test.getAttribute("attributechecker", "class");
		Assert.assertEquals(attribute, "correctclass");
		
		test.verifyAttribute("attributechecker", "class", "correctclass");
		test.verifyCssClass("whichcss", "thisone");
		
		test.click("changecss");
		
		test.verifyCssClass("whichcss", "newclass");
	}

	private void showImage(SeleniumJT test) {
		test.click("showimg");
		
		test.verifyImageSource("bbc", "bbc_0.png");
	}

	private void miscellaneousClicking(SeleniumJT test) {
		// simply testing this click pause works
		test.debugPause(1, "Just testing");
		test.click("showimg", 1);
	}

	private void testLocalStorageCapabilities(SeleniumJT test) {
		// Now testing HTML5 ability to store ocalStorage data
		test.setItemInLocalStorage("seltest", "seltestvalue");
		test.isItemPresentInLocalStorage("seltest");
		test.verifyLocalStorageValue("seltest", "seltestvalue");
		
		test.removeItemFromLocalStorage("seltest");
		Assert.assertTrue(test.getLocalStorageLength() == 0);
		
		test.setItemInLocalStorage("tempKey", "tempValue");
		Assert.assertTrue(test.getLocalStorageLength() == 1);
		
		test.setItemInLocalStorage("tempKey2", "tempValu2");
		Assert.assertTrue(test.getLocalStorageLength() == 2);
		
		test.clearLocalStorage();
		Assert.assertTrue(test.getLocalStorageLength() == 0);
	}
	


}
