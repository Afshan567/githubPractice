package com.banking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPage {
	
	//declaration
	@FindBy(xpath="//li[.='Fund Transfer']") //fund transfer click
	private WebElement fundTransfrclk;
	//initialization
	public FundTransferPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//utilization
	public WebElement getFundTransfrclk() {
		return fundTransfrclk;
	}
	
	//business libraries
	public void fundTransferClick()
	{
		fundTransfrclk.click();
	}
}
