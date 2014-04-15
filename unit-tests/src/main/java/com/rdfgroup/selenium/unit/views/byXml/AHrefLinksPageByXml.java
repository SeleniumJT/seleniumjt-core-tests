package com.rdfgroup.selenium.unit.views.byXml;

import java.io.IOException;

import org.testng.annotations.Test;

import com.jt.selenium.testng.SeleniumTestNgPageObject;
import com.rdfgroup.selenium.unit.views.composite.AHrefLinksPageComposite;

public class AHrefLinksPageByXml extends SeleniumTestNgPageObject
{
	
	@Test
	public void gotoLinksPage() throws IOException {
		new AHrefLinksPageComposite().gotoLinksPage(test);
	}
	
	@Test
	public void verifyAllLinksWork() throws IOException {
		new AHrefLinksPageComposite().verifyAllLinksWork(test);
	}

}
