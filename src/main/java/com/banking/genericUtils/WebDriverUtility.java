package com.banking.genericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * @author Admin
 */
public class WebDriverUtility {
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
public void maximizeTheBrowser(WebDriver driver)
{
	driver.manage().window().maximize();
}
/**
 * This method is used to minimize the browser
 * @param driver
 */
public void minimizeTheBrowser(WebDriver driver)
{
	driver.manage().window().minimize();
}
/**
 * This method will wait until elements in the page gets loaded
 * @param driver
 * @param duration
 */
public void implicitWait(WebDriver driver,int duration)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
}
/**
 * This method will wait until the url of the page gets loaded
 * @param driver
 * @param duration
 * @param expectedurl
 */
public void waitUntilUrlLoads(WebDriver driver, int duration, String expectedurl)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
	wait.until(ExpectedConditions.urlContains(expectedurl));
}
/**
 * This method will wait until the title of the page gets loaded
 * @param driver
 * @param duration
 * @param expectedTitle
 */
public void waitUntilTitleLoads(WebDriver driver, int duration,String expectedTitle)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
wait.until(ExpectedConditions.titleContains(expectedTitle));	
}
/**
 * This method will wait until the element in the page gets loaded
 * @param driver
 * @param duration
 * @param element
 */
public void waitUntilElementToBeclickable(WebDriver driver,int duration,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * This method will ignore NoSuchElementException and continue the execution
 * @param driver
 * @param duration
 */
public void ignoreNoSuchElementException(WebDriver driver, int duration)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
wait.ignoring(NoSuchElementException.class);
}
/**
 * This method will wait until the element to be visible in the page
 * @param element
 * @throws InterruptedException
 */
public void customWait(WebElement element) throws InterruptedException
{
	int count=0;
	while(count<20)
	{
		try	{
			element.click();
			break;
		} catch(Exception e) {
			Thread.sleep(1000);
			count++;
		}
	}
}
/**
 * This method will select a dropdown element based on index
 * @param element
 * @param index
 */
public void selectDropDown(WebElement element,int index)
{
	Select se1=new Select(element);
	se1.selectByIndex(index);
}
/**
 * This method will select a dropdown element based on value
 * @param element
 * @param value
 */
public void selectDropDown(WebElement element,String value)
{
	Select se1=new Select(element);
	se1.selectByValue(value);
}
/**
 * This method will select a dropdown element based on Visible text
 * @param text
 * @param element
 */
public void selectDropDown(String text,WebElement element)
{
	Select se1=new Select(element);
	se1.selectByVisibleText(text);
}
/**
 * This method is used to mouseOver on an element
 * @param driver
 * @param element
 */
public void mouseOverElement(WebDriver driver,WebElement element)
{
	Actions action=new Actions(driver);
	action.moveToElement(element).perform();
}
/**
 * This method is used to rightClick on an element
 * @param driver
 * @param element
 */
public void rightClick(WebDriver driver,WebElement element)
{
	Actions action=new Actions(driver);
action.contextClick(element).perform();
}
/**
 * This method is used to click on enter button
 * @param driver
 */
public void clickOnEnterKey(WebDriver driver)
{
	Actions action=new Actions(driver);
	action.sendKeys(Keys.ENTER).perform();
	
}
/**
 * This method is used to switch from one frame to another using index
 * @param driver
 * @param index
 */
public void switchFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
/**
 * This method is used to switch from one frame to another using webelement
 * @param driver
 * @param element
 */
public void switchFrame(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}
/**
 * This method is used to switch to main frame
 * @param driver
 */
public void switchToMainFrame(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/**
 * This method is used to accept alert popup
 * @param driver
 * @param expectedMsg
 */
public void acceptAlertPopup(WebDriver driver,String expectedMsg)
{
	Alert alt=driver.switchTo().alert();
	if(alt.getText().equalsIgnoreCase(expectedMsg))
	{
		System.out.println("alert msg is verified");
	}
	else
	{
System.out.println("alert msg is not verified");		
	}
	alt.accept();
}
/**
 * This method is used to dismiss the alert popup
 * @param driver
 * @param expectedMsg
 */
public void dismissAlertPopup(WebDriver driver,String expectedMsg)
{
	Alert alt=driver.switchTo().alert();
	if(alt.getText().equalsIgnoreCase(expectedMsg))
	{
		System.out.println("alert msg is verified");
	}
	else
	{
System.out.println("alert msg is not verified");		
	}
	alt.dismiss();
}
/**
 * This method is used to switch from one window to another based on title
 * @param driver
 * @param expectedTitle
 */
public void switchWindowBasedOnTitle(WebDriver driver,String expectedTitle)
{
	Set<String> set = driver.getWindowHandles();
	for(String str:set)
	{
		driver.switchTo().window(str);
		String title=driver.getTitle();
		if(title.contains(expectedTitle))
		{
			break;
		}
	}
}
/**
 * This method is used to switch from one window to another based on url
 * @param driver
 * @param expectedURL
 */
public void switchWindowBasedOnUrl(WebDriver driver,String expectedURL)
{
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	while(it.hasNext())
	{
		String wid = it.next();
		driver.switchTo().window(wid);
		String url=driver.getCurrentUrl();
		if(url.contains(expectedURL))
{
	break;
}
	}
}
/**
 * This method is used to take screenshot whenever the test scripts getting failed
 * @param driver
 * @param screenShotName
 * @return
 * @throws Throwable 
 */
public String takeScreenShot(WebDriver driver,String screenShotName) throws Throwable
{
	TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
	File src=takesScreenshot.getScreenshotAs(OutputType.FILE);
	File dst=new File("./screenShots/"+screenShotName+".png");
	//try{
		Files.copy(src, dst);
		//FileUtils.copyFile(src, dst);
	//}catch(IOException e) {
		//e.printStackTrace();
		return screenShotName;
		}
/**
 * This method is used to scroll to particular element
 * @param driver
 * @param element
 */
public void scrollToParticularElement(WebDriver driver,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView()", element);
}
/**
 * This method is used to perform drag and drop action
 * @param driver
 * @param src
 * @param dest
 */
public void dragAnddrop(WebDriver driver,WebElement src,WebElement dest)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(src, dest);
}
/**
 * This method is used to perform double click action
 * @param driver
 * @param element
 */
public void doubleClickAction(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
act.doubleClick(element).perform();
}
/**
 * This method is used to  press the key
 * @param driver
 * @throws Throwable
 */
public void enterKey(WebDriver driver) throws Throwable
{
	Robot rb=new Robot();
	rb.keyPress(KeyEvent.VK_ENTER);
}
/**
 * This method is used to release the key
 * @param driver
 * @throws Throwable
 */
public void enterRelease(WebDriver driver) throws Throwable
{
	Robot rb=new Robot();
rb.keyRelease(KeyEvent.VK_ENTER);
}
/**
 * This method will perform random scroll
 * @param driver
 */
public void scrollBarAction(WebDriver driver)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,800)", "");
}
/**
 * This method will perform scroll down as per given value
 * @param driver
 * @param x
 * @param y
 */
public void scrollByAmount(WebDriver driver,int x,int y)
{
	Actions act=new Actions(driver);
	act.scrollByAmount(x, y);
}
}