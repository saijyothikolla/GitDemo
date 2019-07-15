package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.TimeUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

/**
 * 
 * @author Saijyothi
 *
 */
public class LoginTest {

	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage loginpage;
	@BeforeMethod
	public void setUp() throws InterruptedException {
		basepage= new BasePage();
		prop=basepage.init_prop();
	driver=basepage.init_driver(prop);
	driver.get(prop.getProperty("url"));
	loginpage=new LoginPage(driver);	
     TimeUtil.mediumWait();
	}
	
	@Test(priority=1,description="verify loginpage title" )
	@Severity(SeverityLevel.NORMAL)
	@Description("Check Login Page Tiltle Is Correct Or Not")
	public void verifyLoginPageTitleTest() {
		String title=loginpage.getLoginPageTitle();
		System.out.println("Login page title is"+title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	}
	
	
	@Test(priority=2,description="verify signup link")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Check SignUp Link On LoginPage")
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginpage.verifySignUpLink());
	}
	
	@Test(priority=3,description="verifyLoginpage")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify LoginPage crediantials")
	public void hubSpotLoginTest() {
		loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
