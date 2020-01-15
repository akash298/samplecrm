package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;

	public LoginTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		
		initialization();
		lp=new LoginPage();
		
		
	}
	/*@Test(priority=0)
	public void verfiytitle()
	{
		String str=lp.validatetitle();
		Assert.assertEquals(str, "Cogmento CRM");
	}*/
	@Test(priority=1)
	public void logincheck() throws Exception
	{
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	/*@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}*/ 
	
	

}
