package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StopDocker {


	public void stopDocker() throws IOException, InterruptedException {
		Runtime runtime = Runtime.getRuntime();

		runtime.exec("cmd /c start docker-down.bat");

		Boolean flag = false;

		// Wait for the logs to be copied to the file
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 30);
		long stopNow = cal.getTimeInMillis(); // final time
		Thread.sleep(3000);
		// parse the file till we get the expected text
		String file = "output.txt";

		while (System.currentTimeMillis() < stopNow) {
			
			if(flag) {
				break;
			}
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

			String cuurentLine = bufferedReader.readLine();
			
			while (cuurentLine != null && !flag) {
				if (cuurentLine.contains("selenium-hub exited")) {
					// Node is up and running and hence we have to delete the file
					System.out.print("Found my text");
					flag = true;
					break;
				}
				cuurentLine = bufferedReader.readLine();
			}
			
			bufferedReader.close();
		}

		
		Assert.assertTrue(flag);
		
		
		
		
		
	}

}
