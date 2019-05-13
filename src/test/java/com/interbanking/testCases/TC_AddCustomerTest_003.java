package com.interbanking.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.interbanking.pageObjects.AddCustomerPage;
import com.interbanking.pageObjects.LoginPage;



public class TC_AddCustomerTest_003 extends BaseClass{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException, AWTException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
	
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		
		Thread.sleep(3000);
AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("9","Feb","1985");	
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
       logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");  //returns true or false
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
		
		
	}

