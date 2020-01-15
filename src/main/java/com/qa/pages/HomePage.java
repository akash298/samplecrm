package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class HomePage extends TestBase{

	
	@FindBy(xpath="//*[@class='right menu']/child::*")
	WebElement Userlabelcheck;
	
	
	@FindBy(xpath="//*[@id='top-header-menu']/div[1]")
	WebElement crmlogo;
	
	@FindBy(xpath="//*[@id='main-nav']/child::a[3]")
	WebElement contacts;
	
	
	@FindBy(xpath="//span[text()='Deals']")
	WebElement Deals;
	
	
	@FindBy(xpath="//*[@id='main-nav']/a[6]")
	WebElement Task;
	
	
	
	public HomePage() throws Exception {
	PageFactory.initElements(driver, this);
	}
	
	
	public String verifytitle()
	{
		
		return driver.getTitle();
	}
	
	public boolean logocheck()
	{
		return crmlogo.isDisplayed();
	}
	
	public String verfiyuserlabel()
	{
		String str=Userlabelcheck.getText();
		return str;
	}
	public ContactsPage oncontactslink() throws Exception
	{
		contacts.click();
		return new ContactsPage();
	}
	public DealPage dealslink()
	{
		Deals.click();
		return new DealPage();
	}
	public TaskPage ontasklink()
	{
		
		Task.click();
		return new TaskPage();
	}

}
