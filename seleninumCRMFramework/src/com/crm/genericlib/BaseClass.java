package com.crm.genericlib;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public  abstract class BaseClass {
	public WebDriver driver;
	FileUtils filee=new FileUtils();
	
	//Properties  pobj=new Properties();
	
	
	@BeforeClass
	public void configbc() throws Throwable{
		System.out.println("lunch the browser");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	@BeforeMethod
	public void configbm() throws Throwable{
		System.out.println("login");
		Properties properties=	filee.getpropertyFileObject();
		String url=properties.getProperty("url");
		driver.get(url);
		String username=properties.getProperty("username");
		driver.findElement(By.name("user_name")).sendKeys(username);
		String psw=properties.getProperty("pwd");
		driver.findElement(By.name("user_password")).sendKeys(psw);
		driver.findElement(By.id("submitButton")).click();
		

	}
	@AfterMethod
	public void configam() throws Throwable{
		System.out.println("logout");
		Actions act=new Actions(driver);
	WebElement webElement=	driver.findElement(By.xpath("//td[@class='small']/img[@src='themes/softed/images/user.PNG']"));
		//driver.findElement(By.linkText("Logout")).click();
		act.moveToElement(webElement).build().perform();
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign Out")));
	Thread.sleep(4000);
	driver.findElement(By.linkText("Sign Out")).click();
	Thread.sleep(4000);

	}
	@AfterClass
	public void configac(){
		System.out.println("close the  browser");
		driver.close();

	}

	

}
