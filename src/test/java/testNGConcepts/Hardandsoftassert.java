package testNGConcepts;

import org.testng.Assert;

public class Hardandsoftassert {
	
	public void hardAssert () {
		int a =10;
		int b =5;
		int c= a+b;
		Assert.assertEquals(c, 16);
		System.out.println("this har assert");
	}
	
	public void softAssert () {
		
		int x = 10;
		int y = 15;
		
		
	}

}
