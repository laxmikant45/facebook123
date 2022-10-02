package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CreateNewAccount;
import pages.Loginorsignuppage;

public class test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Testing\\seleiunm\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		Loginorsignuppage loginorsignuppage =new Loginorsignuppage(driver);
		loginorsignuppage.SendUsername();
		
		loginorsignuppage.SendPassword();
		
		loginorsignuppage.ClickonLoginButton();
	
	}

}
