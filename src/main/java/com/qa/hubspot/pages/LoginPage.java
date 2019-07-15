package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Saijyothi
 *
 */

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

WebDriver driver;
	@FindBy(id = "username")
	WebElement emaild;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "loginBtn")
	WebElement loginbutton;

	@FindBy(linkText = "Sign up")
	WebElement SignUpLink;

//create the constructor of page class	
	public LoginPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	// define actions/methods
	@Step("getting login page title step")
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
   @Step("Check signup link is displayed with is displayed method step..")
	public boolean verifySignUpLink() {
		return SignUpLink.isDisplayed();

	}
    @Step("login to app with username:{0} and password:{1}")
	public HomePage doLogin(String username, String pwd) {
		emaild.sendKeys(username);
		password.sendKeys(pwd);
		loginbutton.click();
		
		return new HomePage(driver);
	}

}
