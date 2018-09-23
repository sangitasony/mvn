package com.crm.organization;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.genericlib.BaseClass;
import com.crm.genericlib.FileUtils;

public class Organistion extends BaseClass{
	
	@Test
public void createOrganistionTest() throws Exception{
		FileUtils fis=new FileUtils();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	//fis.getExcelData("Sheet1", 2, 3);
	driver.findElement(By.xpath("//input[@name='accountname' ]")).sendKeys(fis.getExcelData("Sheet1", 2, 2));
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
}
	@Test(enabled= false)
	public void deleteOrganistionTest(){
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[1]/input")).click();
		driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
}
