package com.banking.genericUtils;


 import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {

	public DatabaseUitility dbu=new DatabaseUitility();
	public ExcelUtility eu=new ExcelUtility();
	public FileUtility fu=new FileUtility();
	public JavaUtility ju=new JavaUtility();
	public WebDriverUtility wdu=new WebDriverUtility();
	public  WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable
	{
		dbu.connectToDB();
		System.out.println("---Connect to DB");
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	//public void configBC(String BROWSER) throws Throwable
	public void configBC() throws Throwable

	{
		String BROWSER = fu.getPropertyKeyValue("browser");

		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			   driver=new ChromeDriver();
			 

		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else 
		{
			System.out.println("Invalid browser");
				
		}
		System.out.println("--Launch the browser--");
		sdriver=driver;
		wdu.maximizeTheBrowser(driver);

	}
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable
	{
		String URL = fu.getPropertyKeyValue("url");
 		driver.get(URL);
		wdu.implicitWait(driver, 10);
 		System.out.println("Logged into app");
	}
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
		System.out.println("Signout from app");
	}
	@AfterClass(alwaysRun = true)
	public void configAC() throws Throwable
	{
		driver.quit();
		System.out.println("---Close the  browser----");
	}
	@AfterSuite(alwaysRun = true)
	public void configAS() throws Throwable
	{
		dbu.closeDB();
		System.out.println("---Close DB connection---");
	}
}
