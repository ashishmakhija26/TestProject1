package com.facebook.pages;

import com.facebook.genericPage.CommonMethods;

public class LoginPage extends CommonMethods {

	public LoginPage() throws Exception {
		super();
}
	//click email
	public void clickEmail() {
		clickWebElement("EmailOrPhone");
		handleLogger("LoginPage", "Clicked on Email");
	}
	
	//Enter Email
	public void enterEmail() {
		enterData("EmailOrPhone", "TestData1");
		handleLogger("LoginPage", "Entered Email");
	}
	public void clearEmail() {
		clearData("EmailOrPhone");
		handleLogger("LoginPage", "Cleared Email");
	}
	//click password
	public void clickPassword() {
		clickWebElement("Password");
		handleLogger("LoginPage", "Clicked on Password");
		
	}
	//Enter Password
	public void enterPassword() {
		enterData("Password", "TestData2");
		handleLogger("LoginPage", "Entered Password");
		
	}
	public void clearPassword() {
		clearData("Password");
		handleLogger("LoginPage", "Cleared Password");
		
	}
	//Get Text
	public void getFacebookText() {
		getWebElementText("FacebookText");
		handleLogger("LoginPage", "Fetched Facebook Text");
	}
	
	// click Login Button
	public void clickLoginButton() {
		clickWebElement("LoginButton");
		handleLogger("LoginPage", "Clicked on Login Button");
	}
	
}
