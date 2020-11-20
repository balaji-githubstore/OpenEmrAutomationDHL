package com.dhl.openemrtest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemoTest {
	
	
	
	@DataProvider
	public Object[][] validData()
	{
		Object[][] main=new Object[3][2];
		// i --> no of test case
		// j --> no of parameters
		main[0][0]="bala";
		main[0][1]="bala123";
		
		main[1][0]="peter";
		main[1][1]="peter123";
		
		main[2][0]="john";
		main[2][1]="john123";
		
		return main;
	}
	
	//bala, bala123  --  0,0   0,1
	//Peter, peter123 -- 1,0   1,1
	//john, john123  --  2,0   2,1
	
	//3 test case with 2 parameter
	
	@Test(dataProvider = "validData")
	public void validTest(String username,String password)
	{
		System.out.println(username+password);
	}

}
