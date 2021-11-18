package remoteTesting.DockerValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;




public class MainPage {
	



	
	public void StartDocker() throws IOException, InterruptedException {
	boolean flag = false;

		ProcessBuilder pb = new ProcessBuilder("/bin/bash","./DockerUp");
		try {
			Process p = pb.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

		} catch (IOException e) {

			e.printStackTrace();
		} 
		 
		String f ="output.txt";
		Thread.sleep(2000);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MILLISECOND, 30000);
		long stopnow = cal.getTimeInMillis();
		
		while (System.currentTimeMillis() < stopnow) {
			if (flag) {
				break;
			}
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String currentLine = reader.readLine();
			
			while (currentLine != null && !flag) {
				System.out.println("Docker is up and running ...");
				flag = true;
				break;

			}
			reader.close();
			
//			Assert.assertTrue(flag);
			Thread.sleep(5000);
			
			
		}

}



	public void StopDocker() throws IOException, InterruptedException {

		boolean flag1 = false;
		ProcessBuilder pb = new ProcessBuilder("/bin/bash","./DockerDown");
		try {
			Process p = pb.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//			String s = null;
//			while ((s = reader.readLine()) != null) {
//				System.out.println(s);
//				reader.close();
//			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		String f1 ="output.txt";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MILLISECOND, 3000);
		long stopnow = cal.getTimeInMillis();
		Thread.sleep(3000);
		while (System.currentTimeMillis() < stopnow) {
			if (flag1) {
				break;
			}
			BufferedReader reader = new BufferedReader(new FileReader(f1));
			String currentLine = reader.readLine();

			while (currentLine != null && !flag1) {
				if (currentLine.contains("1mdockervalidation_selenium-hub_1 exited")) {
					Thread.sleep(3000);
					System.out.println("Docker is exited normaly ...");
					flag1 = true;
					break;
				}
//				currentLine = reader.readLine();
			}
			reader.close();
		}
//		Assert.assertTrue(flag1);
		File file = new File("output.txt");
		
		if (file.exists()) {
			if (file.delete()) 
				System.out.println("History is deleted succesfuly");
		}else {
			System.out.println("File already deleted ");
			
		}
		Thread.sleep(5000);
		
	}

	


}
