package com.banking.ObjectRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.genericUtils.WebDriverUtility;


public class AccOpenFormPage extends WebDriverUtility {
	
	@FindBy(name="gender")
	private WebElement gndr;
	@FindBy(xpath="//option[.='Male']")
	private WebElement gndrdet;
	@FindBy(name="dob")
	private WebElement DOB;
	@FindBy(name="state")
	private WebElement State;
	@FindBy(name="city")
	private WebElement City;
	@FindBy(name="acctype")
	private WebElement AcType;
	@FindBy(xpath="//option[text()='Saving']")
	private WebElement savngAc;
@FindBy(name="submit")
private WebElement Submit;
@FindBy(name="cnfrm-submit")
private WebElement CnfmSubmit;
@FindBy(name="apprvac")
private WebElement approv;
@FindBy(name="application_no")
private WebElement appno;
@FindBy(name="search_application")
private WebElement searchappl;
@FindBy(name="approve_cust")
private WebElement appcust;
@FindBy(xpath="//*[@name='home']")
private WebElement subhome;
@FindBy(xpath="//tbody/tr/td[4]")
private List<WebElement> ActCust;

	public AccOpenFormPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	public WebElement getApprov() {
		return approv;
	}

	public WebElement getAppno() {
		return appno;
	}

	public WebElement getSearchappl() {
		return searchappl;
	}

	public WebElement getAppcust() {
		return appcust;
	}

	public WebElement getSubhome() {
		return subhome;
	}

	public WebElement getGndr() {
		return gndr;
	}
	public WebElement getGndrdet() {
		return gndrdet;
	}
	public WebElement getDOB() {
		return DOB;
	}
	public WebElement getState() {
		return State;
	}
	public WebElement getCity() {
		return City;
	}
	public WebElement getAcType() {
		return AcType;
	}
	public WebElement getSavngAc() {
		return savngAc;
	}
	public WebElement getSubmit() {
		return Submit;
	}
	public WebElement getCnfmSubmit() {
		return CnfmSubmit;
	}
	
	public List<WebElement> getActCust() {
		return ActCust;
	}

	public void accOpenDetails(HashMap<String, String> map, WebDriver driver)
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
	public void accOpenDetails(String dob,String text, int index)
	{
		gndr.click();
		gndrdet.click();
		DOB.click();
		DOB.sendKeys(dob);
		  selectDropDown(text, State);
		  selectDropDown(City, index);
		  AcType.click();
		  savngAc.click();
		  Submit.click();
		  CnfmSubmit.click();
		  }
	public String alertHandling(WebDriver driver)
	{
		Alert al=driver.switchTo().alert();
		String altext=al.getText();
		String appno = "";
		  for(int i=0; i<altext.length(); i++)
		  {
			  if(Character.isDigit(altext.charAt(i)))
					  {
				 appno = appno+altext.charAt(i);
				
					  }

		  }
		  al.accept();
		  System.out.println("application no for opening a/c is:\t"+appno);
return appno;
	}
	public void staffApproval(String apno) throws Throwable
	{
		approv.click();
		appno.sendKeys(apno);
		Thread.sleep(3000);

		searchappl.click();
		appcust.click();
	}
	public String alertHandl(WebDriver driver)
	{
		Alert al2=driver.switchTo().alert();
		String altext2=al2.getText();
		//System.out.println(altext2);
		String accno = "";
		  for(int j=0; j<altext2.length(); j++)
		  {
			  if(Character.isDigit(altext2.charAt(j)))
					  {
				  accno = accno+altext2.charAt(j);
					  }
		  }
		  System.out.println("account no is:"+accno);
		  al2.accept();
return accno;
	}
	public void subHome()
	{
		subhome.click();
	}
	public void AccValidation(String accno)
	{
		for(WebElement we:ActCust)
		{
			if(we.getText().equals(accno))
			{
				System.out.println("Account is created successfully");
				break;
			}
			else

					System.out.println("Account is not created");
		break;
		}

	}
}
