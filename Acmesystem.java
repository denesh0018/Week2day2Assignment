//1. Load url "https://acme-test.uipath.com/login"
//2. Enter email as "kumar.testleaf@gmail.com"
//3. Enter Password as "leaf@12"
//4. Click login button
//5. Get the title of the page and print
//6. Click on Log Out
//7. Close the browser (use -driver.close())


package createLeads;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Acmesystem {

	public static void main(String[] args) {
		
		//Setup Chrome Driver
		WebDriverManager.chromedriver().setup();

		//open the browser
		ChromeDriver object= new ChromeDriver();

		//Load the URL
		object.get("https://acme-test.uipath.com/login");
		
		//Maximize the window screen

		object.manage().window().maximize();
		
		//Using xpath
		object.findElement(By.xpath("//label[contains(text(),'Email:')]/following-sibling::input")).sendKeys("kumar.testleaf@gmail.com");
		
		//using locator
		object.findElement(By.id("password")).sendKeys("leaf@12");
		
		//using xpath
		object.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		//Printing the title
		System.out.println("The Title is= " +object.getTitle());
		
		//logging out with xpath
		object.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
		
		object.close();

	}

}
