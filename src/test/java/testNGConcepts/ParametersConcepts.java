package testNGConcepts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersConcepts {
	@Test
	@Parameters ({"email", "password"})
	public void test (String nameValue, String addressValue) {
		String name =nameValue;
		String address =addressValue;
		
		System.out.println(name);
		System.out.println(address);
		
	}

}
