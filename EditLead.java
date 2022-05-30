package editLead;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		//		* 8	Enter first name
		driver.findElement(By.xpath("(//label[contains(text(),'First name:')]/following-sibling::div/input)[3]")).sendKeys("monika");
		//		* 9	Click Find leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000);
		//		* 10 Click on first resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		//		* 11 Verify title of the page
		String title = driver.getTitle();
		System.out.println(title);

		//		* 12 Click Edit
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		//		* 13 Change the company name
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("Testleaf1");
		//		* 14 Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		//		* 15 Confirm the changed name appears
		String text = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		if (text.contains("Testleaf1"))
			System.out.println("Changed name appeared");
		else
			System.out.println("Changed name not appeared");

		//		* 16 Close the browser (Do not log out)
		driver.close();
	}

}
