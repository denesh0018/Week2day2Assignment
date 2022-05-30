
package duplicateLead;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {

		//Setup Chrome Driver
		WebDriverManager.chromedriver().setup();

		//open the browser
		ChromeDriver driver= new ChromeDriver();

		//		1	Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/login");

		//Maximime the window screen
		driver.manage().window().maximize();

		//		2	Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//		3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//		4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//		5	Click crm/sfa link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//		6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		//		7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//		8	Click on Email
		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		
		//		9	Enter Email
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("jeykee@gmail.com");
		
		//		10	Click find leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000);
		
		//		11	Capture name of First Resulting lead
		String Duplicate = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a")).getText();
		System.out.println(Duplicate);
		
		//		12	Click First Resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		
		//		13	Click Duplicate Lead
		driver.findElement(By.xpath("//a[contains(text(),'Duplicate Lead')]")).click();
		
		//		14	Verify the title as 'Duplicate Lead'
		String title = driver.getTitle();
		System.out.println(title);
		if(title == "Duplicate Lead") 
			System.out.println("Title is " +title);
		else 		
			System.out.println("Title is not " +title);	
		
		//		15	Click Create Lead
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();

		//		16	Confirm the duplicated lead name is same as captured name
		String text = driver.findElement(By.xpath("//span[contains(text(),'First name')]/following::span")).getText();
		System.out.println(text);
		if(Duplicate.equals (text))
			System.out.println("Both name is same");
		else
			System.out.println("Both name is different");

		//		17	Close the browser (Do not log out)
		driver.close();

	}

}


