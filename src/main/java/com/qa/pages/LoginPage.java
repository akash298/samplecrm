package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@class='ui fluid large blue submit button']")
	WebElement submit; 
	
	public LoginPage() throws Exception
	{
		PageFactory.initElements(driver,this);
	}
	public String validatetitle()
	{
		
		return driver.getTitle();
	}
	public HomePage login(String user,String Pass) throws Exception
	{
		
		username.sendKeys(user);
		password.sendKeys(Pass);
		submit.click();
		
		return new HomePage();
		
	}
	
	
}
