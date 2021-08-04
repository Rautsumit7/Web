package Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Webshop {
	
	static Logger log=Logger.getLogger(Webshop.class.getName());
	
    public WebDriver driver;
	
	Properties pro=new Properties();
	
	
	
	@BeforeSuite
	public void browser() throws IOException
	
	{
		FileInputStream fis=new FileInputStream("D:\\cjc134\\corejava\\DemoWebshop_Task\\src\\Webshop.properties");
		pro.load(fis);
		
		System.out.println("URL=="+pro.getProperty("url"));
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ashish3915\\Desktop\\cjc134 batch\\Testing\\Chrome92\\chromedriver.exe");
		 driver=new ChromeDriver();
		
	}
	
	@BeforeTest
	public void before()
	{
		log.info("Before test ");
		driver.get(pro.getProperty("url"));
	}
	
	@BeforeClass
	public void maximizebrowser()
	{
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void url()
	{
		log.info("Before Method");
      
	}


	
	
	

	@Test
	public void RegisterWebshop()
	{
	 driver.findElement(By.id("gender-male")).click();
	 
	driver.findElement(By.xpath("//input[@id=\"FirstName\"]")).sendKeys(pro.getProperty("FirstName"));
	
	driver.findElement(By.xpath("//input[@id=\"LastName\"]")).sendKeys(pro.getProperty("LastName"));
	
	driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys(pro.getProperty("Email"));
	
	driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys(pro.getProperty("Password"));
	
	driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]")).sendKeys(pro.getProperty("ConfPassword"));
	
	driver.findElement(By.xpath("//input[@id=\"register-button\"]")).click();
	}
	

@AfterMethod
	public void capturescreenshot() throws IOException
	{
	  File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("C:\\Users\\Ashish3915\\Desktop\\cjc134 batch\\Testing\\web1.jpj"));
		System.out.println("Screenshot taken successfully....");
		
	}

	@AfterClass
	public void AfterClass()
	{
		
		System.out.println("After class");
	}
	@AfterTest
	public void conclose()
	{
		System.out.println("close...");
	}
	

	@AfterSuite
	public void closedriver()
	{
		System.out.println("Success..");
		driver.quit();
	}
}
	


