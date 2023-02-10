package testNGConcepts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC3 {
	@BeforeClass
	void beforeClass() {
		System.out.println("This is Before Class");
	}
	@AfterClass
	void afterClass() {
		System.out.println("This is After Class");
	}
	
	@BeforeMethod()
	void beforMethod() {
		
		System.out.println("This will execute before every method");
	}
	
	@AfterMethod()
	void afterMethod() {
		
		System.out.println("This will execute After every method");
	}
	
	
	@Test
	void test3() {
		
		System.out.println("This is test 3...");
		
	}
	
	@Test
	void test4() {
		
		System.out.println("This is test 4...");
		
	}
	@BeforeSuite
	void beforeSuit() {
		System.out.println("Before Suit");
	}
	
	@AfterSuite
	void afterSuit() {
		System.out.println("After Suit");
	}
	
}
