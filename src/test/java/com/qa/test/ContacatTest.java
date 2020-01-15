package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class ContacatTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	
	String sheetname="contacts";

	public 	ContacatTest() throws Exception
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		lp=new LoginPage();
		hp=new HomePage();
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(5000);
		cp=hp.oncontactslink();
		Thread.sleep(5000);
		
		
	}
	
	/*@Test(priority=1)
	public void verifyoncontact()
	{
		Boolean b=cp.verifyoncontactspage();
		Assert.assertTrue(b);
	}*/
	
	@Test(enabled=false)
	public void checklist() throws Exception
	{
		cp.verifylistitems("athiest panwar");
	}
	
	@DataProvider
	public Object[][] getCRMdata() throws Exception
	{
		Object[][] data=TestUtil.gettestdata(sheetname);
		return data;
	}
	
	
	@Test(priority=3,dataProvider="getCRMdata")
	public void createnewcontact(String firstname,String lastname,String company,String email)
	{
		
		cp.createcontactspage(firstname,lastname,company,email);
	}
		
	
}
