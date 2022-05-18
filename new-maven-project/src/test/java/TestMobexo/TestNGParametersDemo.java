package TestMobexo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {
	
	@Test
	@Parameters("Name")
	public void Test1(String name) {
		System.out.println("Name is:"+name);
	}
}
