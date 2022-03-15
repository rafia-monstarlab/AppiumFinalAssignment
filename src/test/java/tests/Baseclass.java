package tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Baseclass {
	
	public AndroidDriver<MobileElement> driver;
	String platform;
	
	@BeforeClass
	public void openApplication() throws Exception {
		
		try {
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			this.platform = "android";
			
			if (platform.equalsIgnoreCase("Android")) {
				cap.setCapability("deviceName", "emulator-5556");
				cap.setCapability("platformName", "android");
				cap.setCapability("platformVersion", "12");
		
				cap.setCapability("appPackage", "com.jayway.contacts");
				cap.setCapability("appActivity", "com.jayway.contacts.MainActivity");
				cap.setCapability("app", "/Users/rafiatabassum/Documents/Contacts.apk");
			
			}
			else if(platform.equalsIgnoreCase("ios")){
				cap.setCapability("deviceName", "iPhone 8 Plus Simulator (13.4)");
				cap.setCapability("platformName", "iOS");
				cap.setCapability("automationName", "XCUITest");
				cap.setCapability("udid", "97EFD33A-82FA-4E90-887B-B3AE98B084E3");
//				cap.setCapability("platformVersion", "15.2");
				cap.setCapability("app", "/Applications/ContactsSimulator.app");
				
			}
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver<MobileElement>(url, cap);
		
			System.out.println("Application Started....");
			}
		
		catch (Exception exp) {
			System.out.println("Cause is :" +exp.getCause());
			System.out.println("Message is :" +exp.getMessage());
			exp.printStackTrace();
			}
	}

	
	@AfterClass
	public void teardown() {
		driver.quit();
		System.out.println("----> Test Successfull! Exited from the app");
	}

}
