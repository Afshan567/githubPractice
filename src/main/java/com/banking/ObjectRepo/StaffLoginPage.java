package com.banking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage {
	@FindBy(name="staff_id")
	private WebElement StaffID;
	@FindBy(name="password")
	private WebElement Passwd;
	@FindBy(name="staff_login-btn")
	private WebElement lognClk;
	@FindBy(xpath="//a[.='Staff Login']")
	private WebElement stffclk;
	
	public StaffLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getStffclk() {
		return stffclk;
	}

	public WebElement getStaffID() {
		return StaffID;
	}
	public WebElement getPasswd() {
		return Passwd;
	}
	public WebElement getLognClk() {
		return lognClk;
	}
 
public void staffLog(String stfid,String pwd)
{
	stffclk.click();
	StaffID.sendKeys(stfid);
	Passwd.sendKeys(pwd);
	lognClk.click();
}
public void staffClk()
{
	stffclk.click();
}
}
