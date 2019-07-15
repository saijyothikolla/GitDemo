 package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.TimeUtil;

public class HomePageTest {
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage loginpage;
	HomePage homePage;
	@BeforeMethod
	public void setUp() throws InterruptedException {
		basepage= new BasePage();
		prop=basepage.init_prop();
	driver=basepage.init_driver(prop);
	driver.get(prop.getProperty("url"));
	loginpage=new LoginPage(driver);	
     TimeUtil.mediumWait();
    homePage= loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
     
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
	String title=homePage.getHomePageTitle();
	System.out.println("Home Page title is:"+title);
	Assert.assertEquals(title,Constants.HOME_PAGE_TITLE);
		
	}
	
	@Test(priority=2)
	public void verifyHomePageheader() {
		String headerValue=homePage.getHomePageHeadervalue();
		System.out.println("Homepage haeder value is:"+headerValue);
		Assert.assertEquals(headerValue,Constants.HOME_PAGE_HEADER);
		}
	
	
	@Test(priority=3)
	public void verifyLoggedInUserAccountNameTest() {
		String accountName=homePage.getLoggedInAccountValue();
		System.out.println("LoggedIn account name is:"+accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
