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


public class ChromeTest2 extends MainPage {

	MainPage mainPage;
	@BeforeTest()
	 public void starDockerFile() throws IOException, InterruptedException {
		mainPage=new MainPage();
		mainPage.StartDocker(); 
		
	}
@Test 
	public void  test2()throws MalformedURLException {
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.get("http://www.gmail.com");
		System.out.println(driver.getTitle());
		
		driver.close();
		

	}
@AfterTest
public void stopDockerDeleteFile() throws IOException, InterruptedException {
	mainPage=new MainPage();
    mainPage.StopDocker();
   
    


}


} 