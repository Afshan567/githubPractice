package com.banking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	@FindBy(name="customer_id") // user's customer id
	private WebElement custID;
	@FindBy(name="password") // user's password
	private WebElement Password;
	@FindBy(name="login-btn") // login button click
	private WebElement logBtn;
	
	public UserLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustID() {
		return custID;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLogBtn() {
		return logBtn;
	}

	public void custLogin(String usname,String pswd)
	{
		custID.sendKeys(usname);
		Password.sendKeys(pswd);
		logBtn.click();
	}
}
