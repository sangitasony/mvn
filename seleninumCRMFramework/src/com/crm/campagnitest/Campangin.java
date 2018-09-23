package com.crm.campagnitest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.genericlib.BaseClass;
import com.crm.genericlib.FileUtils;

public class Campangin  extends BaseClass{
	@Test
	public void createcampngTest() throws Exception{
		Actions act=new Actions(driver);
	WebElement web=	driver.findElement(By.xpath("//table[@class='hdrTabBg']//td[22]/a"));
	act.moveToElement(web).perform();
	driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
	
	driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	FileUtils fileUtils=new FileUtils();
	driver.findElement(By.xpath("//td[@class='dvtCellInfo']/input[@name='campaignname']")).sendKeys(fileUtils.getExcelData("Sheet3", 2, 2));
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
	}
	@Test(enabled=false)
public void deletecampngTest(){
		System.out.println("delete");
		Actions act=new Actions(driver);
		WebElement web=	driver.findElement(By.xpath("//table[@class='hdrTabBg']//td[22]/a"));
		act.moveToElement(web).perform();
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[1]/input")).click();
		
		driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
		
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		
		
}
}
