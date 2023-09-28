package com.banking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCustByAccNoPage {

	@FindBy(name="account_no") //customer a/c no
	private WebElement accNo;
	@FindBy(name="submit_view") //submit button
	private WebElement submit;
	@FindBy(xpath="//div[@class='cust_details']/descendant::label[2]")// capturing account detail
	private WebElement accDetal;
	@FindBy(xpath="//tbody/tr[2]/td[3]")
	private WebElement accNo1;
	
	
	
	public WebElement getAccNo1() {
		return accNo1;
	}

	
	public ViewCustByAccNoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getAccNo() {
		return accNo;
	}

	public WebElement getSubmit() {
		return submit;
	}

	
public WebElement getAccDetal() {
		return accDetal;
	}

public void custView(String acno)
{
	accNo.sendKeys(acno);
	submit.click();
}


public String benefAccNo()
{
	return accNo1.getText();
	
}
public void custAccDet(String acno)
{
	accNo.sendKeys(acno);
	submit.click();
	System.out.println("a/c details are matching in view beneficiary & view customer details by a/c no");	
	}

/*public void custValidate()
{
	 
		String acDet=accDetal.getText();
		String accdet = "";
		 for(int i=0; i<acDet.length(); i++)
		 {
			  if(Character.isDigit(acDet.charAt(i)))
					  {
				 accdet = accdet+acDet.charAt(i);
				
					  }
		 }
		if(benefAccNo().equals(accdet))
		{
		System.out.println("a/c details are matching in view beneficiary & view customer details by a/c no");	
		}
		else
		{
		System.out.println("a/c details are not matching");
		}

}*/


}
