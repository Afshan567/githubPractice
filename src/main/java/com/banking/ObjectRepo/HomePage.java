package com.banking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//declaration
	@FindBy(xpath="//li[.='Fund Transfer']") //fund transfer click
	private WebElement fundTransfrclk;
	@FindBy(xpath="//li[.='Open Account']") // open a/c click
	private WebElement openAccClk;
	@FindBy(xpath="//div[@class='ebanking']") // internet banking mouse over
	private WebElement intrntBnkgmOver;
	@FindBy(xpath="//a[@href='customer_login.php']") // after internet banking mouse over, clicking on login
	private WebElement loginClk;
	
	@FindBy(xpath="//a[.='Staff Login']") //staff click
	private WebElement stfClk;
	
	
	
//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization



	public WebElement getFundTransfrclk() {
		return fundTransfrclk;
	}



	/*public void setFundTransfrclk(WebElement fundTransfrclk) {
		this.fundTransfrclk = fundTransfrclk;
	}*/



	public WebElement getOpenAccClk() {
		return openAccClk;
	}



	//public void setOpenAccClk(WebElement openAccClk) {
		//this.openAccClk = openAccClk;
	//}



	public WebElement getIntrntBnkgmOver() {
		return intrntBnkgmOver;
	}



	//public void setIntrntBnkgmOver(WebElement intrntBnkgmOver) {
		//this.intrntBnkgmOver = intrntBnkgmOver;
	//}



	public WebElement getLoginClk() {
		return loginClk;
	}



	//public void setLoginClk(WebElement loginClk) {
		//this.loginClk = loginClk;
	//}



	public WebElement getStfClk() {
		return stfClk;
	}



	//public void setStfClk(WebElement stfClk) {
		//this.stfClk = stfClk;
	//}
	public void openAccClk()
	{
		openAccClk.click();
	}

}
