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
import pages.Loginorsignuppage;

public class verifySexOptions extends base {
	private WebDriver driver;
	private Loginorsignuppage loginorsignuppage;
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
		loginorsignuppage =new Loginorsignuppage(driver);
	}
	@BeforeMethod
	public void openURL() {
		driver.get("https://www.facebook.com/");		
		loginorsignuppage =new Loginorsignuppage(driver);
		createNewAccount=new CreateNewAccount(driver);
		soft = new SoftAssert();
		createNewAccount.clickonCreatenewaccount();
	}
	
	@Test
	public void verifySexButtons() {
		boolean result=createNewAccount.customIsSelected();
		soft.assertFalse(result);
		boolean result1=createNewAccount.maleIsSelected();
		soft.assertFalse(result1);
		boolean result2=createNewAccount.womenIsSelected();
		soft.assertFalse(result2);
		soft.assertAll();
		}
	@Test
	public void verifyCustomButtons() {
		boolean result3=createNewAccount.clickOnCustom();
		soft.assertTrue(result3);
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


