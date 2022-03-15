package pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class contactsearchpageobject {
	
	public contactsearchpageobject(AppiumDriver<MobileElement>driver) {
		try {
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
		}catch(Exception e) {
			System.out.println("Rafiat contactpageobject"+e);
		}
		
	}
	
	@AndroidFindBy (id = "com.jayway.contacts:id/main_search")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeSearchField[@name='Search for contact']")
	MobileElement searchField;
	
	@AndroidFindBy (id = "com.jayway.contacts:id/name")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name='Jenny Cherry']")
	MobileElement validsearchresult;
	
	@AndroidFindBy (id = "com.jayway.contacts:id/main_text")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name='No Results']")
	MobileElement invalidseachresult;
	
	@AndroidFindBy (id = "com.jayway.contacts:id/phonenumber")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name='+1(959)-1775994']")
	MobileElement phonenumber;
	
	public void search(String name) {
		searchField.clear();
		System.out.println("----> Cleared search field");
		searchField.sendKeys(name);
		System.out.println("----> Name inserted on Search field");
	}
	
	
	public String validsearchresult() {
		String name = validsearchresult.getText();
		System.out.println("----> Searched by Valid/Listed name");
		return name;
	}

	public void clickonname() {
		validsearchresult.click();
		System.out.println("----> Name Clicked");
	}
	
	public String phonenumber() {
		String phnnumber = phonenumber.getText();
		System.out.println("----> Got Phone number");
		return phnnumber;
	}
	
	public String invalidseachresult() {
		String name = invalidseachresult.getText();
		System.out.println("----> Searched by invalid name");
		return name;
	}
}
