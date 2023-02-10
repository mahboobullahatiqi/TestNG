package testNGConcepts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Annotations {
	
	
	
	@BeforeMethod
	public void beforeMethod () {
		System.out.println("this is before method messsage");
	}
	@AfterMethod
	public void AfterMethod () {
		System.out.println("this is after method messsage");
	}
	
	@ Test (priority =1)
	public void test () {
		System.out.println("this is test case it self");
		
	}

	@ Test (priority =2)
	public void testOne() {
		System.out.println("this is test case one");
		
	}
	@ Test (priority =3)
	public void testTwo() {
		System.out.println("this is test case Two");
		
	}
	@ Test (priority =4, invocationCount = 10)
	public void testThree  () {
		System.out.println("this is test case three");
	}
	
	@ Test (enabled =false)
	public void testFour () {
		System.out.println("this is test case four");
		
	}
	@ Test
	public void alphaTest () {
		System.out.println("This is alpha test");
	}
	@ Test
	public void alphaTestOne () {
		System.out.println("This is alpha test one");
	}

}
