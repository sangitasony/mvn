package com.crm.contactTest;

import static org.testng.Assert.fail;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.genericlib.BaseClass;
import com.crm.genericlib.FileUtils;

public class Contacts extends BaseClass {
	@Test
	public void createContactsTest() throws Exception{
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//img[@title='Create Contact...']
		FileUtils fileUtils=new FileUtils();
		driver.findElement(By.name("firstname")).sendKeys(fileUtils.getExcelData("Sheet2", 4,2));
		driver.findElement(By.name("lastname")).sendKeys(fileUtils.getExcelData("Sheet2", 4, 3));
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
	 Set<String>set=driver.getWindowHandles();
	 Iterator<String> it=set.iterator();
	 String  Parenntid =it.next();
	 String childid=it.next();
	 driver.switchTo().window(childid);
	 driver.findElement(By.xpath("//table[@class='small']/tbody/tr[4]/td[1]/a")).click();
	 driver.switchTo().window(Parenntid);
	 driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
	}
	@Test(enabled = false)
	public void deletecontactTest(){
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[1]/input")).click();
		driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
		
		Alert alert=driver.switchTo().alert();
	
		alert.getText();
		alert.accept();
		
	}
}
