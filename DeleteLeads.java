package createLeads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.internal.Options;

public class DeleteLeads {

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
		//		8	Click on Phone
		driver.findElement(By.linkText("Phone")).click();
		//		9	Enter phone number
		driver.findElement ( By.xpath ( "//input[@name='phoneCountryCode']" ) ).clear ( );
		driver.findElement ( By.xpath ( "//input[@name='phoneCountryCode']" ) ).sendKeys ( "1" );
		driver.findElement ( By.xpath ( "//input[@name='phoneAreaCode']" ) ).clear ( );
		driver.findElement ( By.xpath ( "//input[@name='phoneAreaCode']" ) ).sendKeys ( "978" );
		driver.findElement ( By.xpath ( "//input[@name='phoneNumber']" ) ).clear ( );
		driver.findElement(By.xpath(" (//label[contains(text(),'Phone Number:')]/parent::div)[4]//input[@name='phoneNumber']")).sendKeys("9539832");
		//		10	Click find leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads') and @type='button']")).click();
		// 		Without thread.Sleep wrong result is being printed.
		Thread.sleep ( 2000 );
		//		11	Capture lead ID of First Resulting lead
		WebElement obj = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String obj1 = obj.getText();
		System.out.println("First lead id is "+obj1);		
		//		12	Click First Resulting lead
		obj.click();
	//		13	Click Delete
		driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
		//		14	Click Find leads
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		//		15	Enter captured lead ID
		driver.findElement(By.xpath("//label[contains(text(),'Lead ID:')]/following-sibling::div/input")).sendKeys(obj1);
		//		16	Click find leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads') and @type='button']")).click();
		Thread.sleep ( 2000 );
		//		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		WebElement obje=driver.findElement(By.xpath("//div[contains(text(),'No records to display')]"));
		String obj2=obje.getText();
		System.out.println("Result is " +obj2 );
		//		18	Close the browser (Do not log out)
		driver.close();
	}

}
