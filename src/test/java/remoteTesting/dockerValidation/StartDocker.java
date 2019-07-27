package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StartDocker {

	
	public void startDocker() throws IOException, InterruptedException {
		//Delete the file
				File f = new File("output.txt");
				if(f.delete()) {
					System.out.println("File deleted successfully");
				}
				
				
		
		Runtime runtime = Runtime.getRuntime();

		runtime.exec("cmd /c start docker-up.bat");

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
				if (cuurentLine.contains("The node is registered to the hub and ready to use")) {
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
		
		//After server got started create 5 intances
		runtime.exec("cmd /c start scaleChrome.bat");
		Thread.sleep(15000); //wait for 5 seconds for service s to run
		
		//Stop the docker and delete the file [so that we don't end up runni gthe logs from old file]
		//Create another batch file to stop the docker
//		runtime.exec("cmd /c start docker-down.bat");
		
		
	}

}
