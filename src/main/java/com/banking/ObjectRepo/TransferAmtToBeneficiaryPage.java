package com.banking.ObjectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

 
public class TransferAmtToBeneficiaryPage {
@FindBy(name="beneficiary") //click on beneficiary
private WebElement BeneficiaryClk;
@FindBy(xpath="//option[@value='1011901011225']") //selecting 1st option
private WebElement slctBeniciary;
@FindBy(xpath="//tbody/tr/td[4]")
private List<WebElement> activecust;

public TransferAmtToBeneficiaryPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}


public List<WebElement> getActivecust() {
	return activecust;
}


public WebElement getBeneficiaryClk() {
	return BeneficiaryClk;
}
public WebElement getSlctBeniciary() {
	return slctBeniciary;
}
	public String benefValidate()
	{
		String benefacno=	slctBeniciary.getText();
		String accdet = "";
		  for(int i=0; i<benefacno.length(); i++)
		  {
			  if(Character.isDigit(benefacno.charAt(i)))
					  {
				 accdet = accdet+benefacno.charAt(i);
				
					  }
		  }
		return accdet;
	}

public void activCustValidate(String benfac)
{
 	
	//for(WebElement we:activecust)	
	//{
		/*if(we.getText().equals(benfac))
		{
			 System.out.println("beneficiary a/c details are displayed in view active customer");
break;
		}
		else {
			System.out.println("beneficiary details are not displayed"); 
		
	}*/
		/*for(int i=0;i<activecust.size();i++)
		{
		Assert.assertEquals(activecust.get(i).getText(), benfac,"beneficiary a/c details checking in view active customer");
		break;
		}*/
	for(WebElement we:activecust)
	{
		Assert.assertEquals(we.getText(),benfac);
		break;
	}
	
}
}

