package by.htp.gameCities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class AppTest {
	@BeforeClass
	public static void bc(){
		Client client = new Client();
		client.clientServer();
	}
	
	@Test
	public void test(){
		
	}
	
	@AfterClass
	public void ac(){
		//driver.quit();
	}
}
