package remoteTesting.dockerValidation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeTest1 {
	
	
	@BeforeTest
	public void startDocker() throws IOException, InterruptedException {
		StartDocker s= new StartDocker();
		s.startDocker();
	}
	
	@AfterTest
	public void stopDocker() throws IOException, InterruptedException {
		StopDocker s= new StopDocker();
		s.stopDocker();
	}
	
	@Test
	public void test1() throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities desiredCapabilities=DesiredCapabilities.chrome();
		URL url= new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url,desiredCapabilities);
		//RemoteWebDriver(url,desiredCapabilities)
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
	}

}
