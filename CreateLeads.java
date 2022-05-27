//Using Basic xPath writing below code

//Launch URL "http://leaftaps.com/opentaps/control/login"
//		  2. Enter UserName and Password Using Id Locator
//		  3. Click on Login Button using Class Locator
//		  4. Click on CRM/SFA Link
//		  5. Click on Leads Button
//		  6. Click on Create Lead 
//		  7. Enter CompanyName Field Using id Locator
//		  8. Enter FirstName Field Using id Locator
//		  9. Enter LastName Field Using id Locator
//		  10. Enter FirstName(Local) Field Using id Locator
//		  11. Enter Department Field Using any Locator of Your Choice
//		  12. Enter Description Field Using any Locator of your choice 
//		  13. Enter your email in the E-mail address Field using the locator of your choice
//		  14. Select State/Province as NewYork Using Visible Text
//		  15. Click on Create Button

package createLeads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Setup Chrome Driver
				WebDriverManager.chromedriver().setup();

				//open the browser
				ChromeDriver driver= new ChromeDriver();

				//Load the URL
				driver.get("http://leaftaps.com/opentaps/control/login");

				//Maximime the window screen

				driver.manage().window().maximize();
//Attribute xPath
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
				driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
//Partial Text based xPath
				driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
//Text based xPath
				driver.findElement(By.xpath("//a[text()='Leads']")).click();
				driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
//Using and condition in attribute based xpath
				driver.findElement(By.xpath("//input[@id='createLeadForm_companyName'and @name='companyName']")).sendKeys("Testleaf002");
//Using or condition in attribute based xpath
				driver.findElement(By.xpath("//input[@name='Firstname' or @id='createLeadForm_firstName']")).sendKeys("Test");		
//Partial Attribute xpath
				driver.findElement(By.xpath("//input[contains(@id,'lastName')]")).sendKeys("Leaf");
				driver.findElement(By.xpath("//input[contains(@id,'firstNameLocal')]")).sendKeys("Leaf001");
//Attribute xpath				
				driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("Department");
				driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("Description");
				driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("testleaf001@gmail.com");
//Attribute xpath
				WebElement ele = driver.findElement(By.xpath("//select[@id='createLeadForm_generalStateProvinceGeoId']"));
				Select elem = new Select(ele);
				elem.selectByVisibleText("New York");
//Attribute xpath
				driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
				
				driver.close();

	}

}
