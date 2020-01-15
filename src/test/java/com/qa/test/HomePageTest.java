package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.DealPage; 
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.TaskPage;

public class HomePageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	DealPage dp;
	TaskPage tp;
	
	public HomePageTest() throws Exception
	{
		super();
	}
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		lp=new LoginPage();
		cp=new ContactsPage();
		dp=new DealPage();
		tp=new TaskPage();
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		
	}
	@Test(priority=1)
	public void checktitle()
	{
		
		String str=hp.verifytitle();
		Assert.assertEquals(str, "Cogmento CRM");
		System.out.println("title:"+str);
		
		
	}
	@Test(priority=2)
	public void crmlogo()
	{
		boolean b=hp.logocheck();
		Assert.assertTrue(b);
		System.out.println("image:"+b);
	}
	@Test(priority=3)
	public void usernametest()
	{
		String str=hp.verfiyuserlabel();
		Assert.assertEquals(str,"akash panwar");
		System.out.println("username:"+str);
	}
	@Test(priority=4)
	public void contactsclick() throws Exception
	{
		cp=hp.oncontactslink();
	}
	@Test(priority=5)
	public void dealsclick()
	{
		dp=hp.dealslink();
	}
	@Test(priority=6)
	public void taksclick()
	{
		tp=hp.ontasklink();
	}
	/*@AfterMethod
	public void teardown()
	{
		driver.quit();
	}*/
	
}
