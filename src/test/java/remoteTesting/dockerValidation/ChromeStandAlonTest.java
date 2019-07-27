package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeStandAlonTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
			
		DesiredCapabilities desiredCapabilities=DesiredCapabilities.chrome();
		URL url= new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url,desiredCapabilities);
		//RemoteWebDriver(url,desiredCapabilities)
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		
	}

}
