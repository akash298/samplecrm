package com.qa.pages;

import org.apache.poi.hssf.record.CountryRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//th[contains(text(),'Name')]")
	WebElement element;
	
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/a/button")
	WebElement newadd;
	
	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/div/input")
	WebElement firstname;
	
	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[1]/div[2]/div/div/input")
	WebElement lastname;
	
	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[4]/div/div/div/div/div[1]/input")
	WebElement emailtype ;
	
	
	
	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/input")
	WebElement Companypath;
	
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/button[2]")
	WebElement save;
	
	

	
	

	public ContactsPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyoncontactspage()
	{
		return element.isDisplayed();
	}
	public void verifylistitems(String str) throws Exception
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(text(),'"+str+"')]")).click();;
		
		
	}
	
	
	public void createcontactspage(String firstname2, String lastname2, String company, String email) {
		// TODO Auto-generated method stub
		newadd.click();
		firstname.sendKeys(firstname2);
		lastname.sendKeys(lastname2);
		emailtype.sendKeys(email);
		Companypath.sendKeys(company);
		save.click();
		
	}
}
