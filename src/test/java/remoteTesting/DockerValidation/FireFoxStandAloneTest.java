package remoteTesting.DockerValidation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FireFoxStandAloneTest {

@Test(priority = 3)
	public void test3() throws MalformedURLException {
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.get("http://www.ebay.com");
		System.out.print(driver.getTitle());
		
		driver.close(); 

	}

}
