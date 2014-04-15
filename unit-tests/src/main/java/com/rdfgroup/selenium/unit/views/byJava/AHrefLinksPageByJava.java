package com.rdfgroup.selenium.unit.views.byJava;

import java.io.IOException;

import com.jt.selenium.SeleniumJT;
import com.jt.selenium.page.PageObject;
import com.rdfgroup.selenium.unit.views.composite.AHrefLinksPageComposite;

public class AHrefLinksPageByJava extends PageObject
{
	
	public AHrefLinksPageByJava(SeleniumJT test) {
		super(test);
	}

	public void gotoLinksPage() throws IOException {
		new AHrefLinksPageComposite().gotoLinksPage(test);
	}
	
	public void verifyAllLinksWork() throws IOException {
		new AHrefLinksPageComposite().verifyAllLinksWork(test);
	}


}
