package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeTest3 {

	@Test
	public void test3() throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities desiredCapabilities=DesiredCapabilities.chrome();
		URL url= new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url,desiredCapabilities);
		//RemoteWebDriver(url,desiredCapabilities)
		driver.get("http://yahoo.com");
		System.out.println(driver.getTitle());
	}

}
