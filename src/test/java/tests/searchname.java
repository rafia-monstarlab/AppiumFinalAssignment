package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import pages.contactsearchpageobject;

public class searchname extends Baseclass{
	
	contactsearchpageobject contactpage;
	
	@Test (priority = 2, enabled=true)
	public void searchJenny() throws InterruptedException {
		Thread.sleep(2000);
		
		try {
		contactpage = new contactsearchpageobject(driver);
		contactpage.search("Jenn");
		String name = contactpage.validsearchresult();
		Assert.assertEquals(name, "Jenny Cherry");
		}catch (Exception e){
			System.out.println("Error message of searchname class"+e);
		}
		
		
	}
	

	@Test (priority = 1, enabled = true)
	public void SearchTamim() {
		try {
			contactpage = new contactsearchpageobject(driver);
			contactpage.search("Tamim");
			String expected_text;
			
			if (super.platform == "ios")
				expected_text = "No Results";
			else
				expected_text = "No contacts found with \"Tamim\" in the name";
			
			String actual_text = contactpage.invalidseachresult();
			Assert.assertEquals(actual_text, expected_text);
			
		}catch (Exception e){
			System.out.println("Error message of searchname class"+e);
		}
		
	}
	
	
	@Test (priority = 3, enabled= true, dependsOnMethods = {"searchJenny"})
	public void clickonname() {
		contactpage = new contactsearchpageobject(driver);
		contactpage.search("Jenn");
		contactpage.clickonname();
		String phonenumber = contactpage.phonenumber();
		Assert.assertEquals(phonenumber, "+1(959)-1775994");
		
	}
	
}
