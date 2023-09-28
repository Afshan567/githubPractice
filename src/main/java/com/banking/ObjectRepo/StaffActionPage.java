package com.banking.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.genericUtils.WebDriverUtility;

public class StaffActionPage extends WebDriverUtility {

	@FindBy(name="viewdet") //view active customer
	private WebElement viewCustDetls;
	@FindBy(name="view_cust_by_ac") //view customer details by a/c no
	private WebElement viewCustByAcc;
	@FindBy(name="apprvac") // approve pending a/c
	private WebElement Approv;
	@FindBy(name="del_cust") // delete customer
	private WebElement deltCust;
	@FindBy(name="credit_cust_ac") //credit customer
	private WebElement crdtCust;
	@FindBy(name="credit_btn")
	private WebElement credtbtn;
	@FindBy(name="logout_btn")
	private WebElement lgout;
	@FindBy(xpath="//*/a[.='Home']")
	private WebElement HOME;
	@FindBy(xpath="//div[@class='ebanking']")
	private WebElement Interntbnkng;
	@FindBy(xpath="//a[@href='customer_login.php']")
	private WebElement lgin;
	@FindBy(name="login-btn")
	private WebElement lgn;
	@FindBy(xpath="//li[.='Statement']")
	private WebElement Statemnt;
	
	public StaffActionPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getLgin() {
		return lgin;
	}

	public WebElement getLgn() {
		return lgn;
	}

	public WebElement getStatement() {
		return Statemnt;
	}

	public WebElement getInterntbnkng() {
		return Interntbnkng;
	}

	public WebElement getHOME() {
		return HOME;
	}

	public WebElement getLgout() {
		return lgout;
	}

	public WebElement getCredtbtn() {
		return credtbtn;
	}

	public WebElement getViewCustDetls() {
		return viewCustDetls;
	}

	public WebElement getViewCustByAcc() {
		return viewCustByAcc;
	}

	public WebElement getApprov() {
		return Approv;
	}

	public WebElement getDeltCust() {
		return deltCust;
	}

	public WebElement getCrdtCust() {
		return crdtCust;
	}
	public void viewCustbyAcc()
	{
		viewCustByAcc.click();
	}
	public void viewActiveCust()
	{
		viewCustDetls.click();
	}
	public void CreditCust()
	{
		crdtCust.click();
	}
	public void creditCustDet(HashMap<String, String> map, WebDriver driver)
	{
		for(Entry<String, String> s:map.entrySet())
		{
			//if(s.getKey().contains("accountname"))
			//{
			//driver.findElement(By.name(s.getKey())).sendKeys(s.getValue()+jLib.getRandomNumber());
			//}
		 	//else
			//{
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
			//}
		}
		
}
	public void creditclk(String text, WebDriver driver)
	{
		credtbtn.click();
		acceptAlertPopup(driver, text);
		lgout.click();
		HOME.click();
		scrollByAmount(driver, 0, 400);
		mouseOverElement(driver, Interntbnkng);
		lgin.click();
	}
	public void custLogn(HashMap<String, String> map, WebDriver driver)
	{
		for(Entry<String, String> s:map.entrySet())
		{
			//if(s.getKey().contains("accountname"))
			//{
			//driver.findElement(By.name(s.getKey())).sendKeys(s.getValue()+jLib.getRandomNumber());
			//}
		 	//else
			//{
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
			//}
		}
		lgn.click();
		Statemnt.click();
	}
}