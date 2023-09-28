package com.banking.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewBeneficiaryPage {
@FindBy(name="view_beneficiary") //click on view beneficiary
private WebElement benfcryClk;
@FindBy(name="go_back")
private WebElement bckbutn;

public ViewBeneficiaryPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
public WebElement getBenfcryClk() {
	return benfcryClk;
}

public WebElement getBckbutn() {
	return bckbutn;
}
public void viewBenef()
{
	benfcryClk.click();
}
}
