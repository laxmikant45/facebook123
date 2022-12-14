package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import broswerSetup.base;
import pages.CreateNewAccount;

public class VerifyAttributeValueCreateNewAccount extends base {
	private WebDriver driver;
	private CreateNewAccount createNewAccount;
	private SoftAssert soft;
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName) {
		if(browserName.equals("Chrome")) 
		{
		driver=openChromeBrowser();
		}
		if(browserName.equals("Edge"))
		{
		  driver=openEdgeBrowser();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@BeforeClass
	public void createPOMObject() {
		createNewAccount=new CreateNewAccount(driver);
		
	}
	
	@BeforeMethod
	public void openURL() {
		driver.get("https://www.facebook.com/");
		soft = new SoftAssert();
		createNewAccount.clickonCreatenewaccount();
	}
	
	@Test (priority =1)
	public void verifyAttributeValueFirstName() {
		String firstname=createNewAccount.getAttributeValueFirstName();
		boolean result =firstname.equals("First name");
		soft.assertTrue(result);
		soft.assertAll();
	}
	
	@Test  (priority =2)
	public void verifyAttributeValueLastName() {
		String lastname=createNewAccount.getAttributeValueLastName();
		boolean result =lastname.equals("Surname");
		soft.assertTrue(result);
		soft.assertAll();
	}
	
	@Test  (priority =3)
	public void verifyAttributeValueMobileEmailId() {
		String mobileNo=createNewAccount.getAttributeValueMobileNoEmailId();
		boolean result =mobileNo.equals("Mobile number or email address");
		soft.assertTrue(result);
		soft.assertAll();
	}
	
	@AfterClass
	public void removeObject() {
		createNewAccount=null;
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.gc();
	}
}
