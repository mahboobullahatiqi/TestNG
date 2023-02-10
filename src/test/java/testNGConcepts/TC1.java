package testNGConcepts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC1 {
	@BeforeClass
	void beforeClass() {
		System.out.println("This is Before Class");
	}

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
	void test1() {

		System.out.println("This is test 1...");

	}

	@Test
	void test2() {

		System.out.println("This is test 2...");
	}
	
	@BeforeTest
	void beoforeTest() {
		
		System.out.println("This will run before Test");
	}
	
	@AfterTest
	void afterTest() {
		
		System.out.println("This will run after Test");
	}

}
