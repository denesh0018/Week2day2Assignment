
// Step 1: Download and set the path 
// Step 2: Launch the chromebrowser
// Step 3: Load the URL https://en-gb.facebook.com/
// Step 4: Maximise the window
// Step 5: Add implicit wait
// Step 6: Click on Create New Account button
// Step 7: Enter the first name
// Step 8: Enter the last name
// Step 9: Enter the mobile number
// Step 10: Enterthe password
// Step 11: Handle all the three drop downs
// Step 12: Select the radio button "Female" 
//      ( A normal click will do for this step) 

package createLeads;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Setup Chrome Driver
		WebDriverManager.chromedriver().setup();

		//open the browser
		ChromeDriver object= new ChromeDriver();

		//Load the URL
		object.get("https://en-gb.facebook.com/");
		
		//Maximize the window screen

		object.manage().window().maximize();
		
		//Implicit wait
		object.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Using  elder to younger sibling xpath
		object.findElement(By.xpath("//a[contains(text(),'Forgotten password')]/following::a")).click();
		
		//Using grandparent to grandchild xpath
		object.findElement(By.xpath("//form[@id='reg']//input[@name='firstname']")).sendKeys("First");
		
		//using name locator
		object.findElement(By.name("lastname")).sendKeys("Last");
		
		//using name locator
		object.findElement(By.name("reg_email__")).sendKeys("9000090000");
		
		//using attribute based xpath
		object.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("Password");
		
		//updateing the date of birth
		//Day
		WebElement obj = object.findElement(By.id("day"));
		Select obj1 = new Select(obj);
		obj1.selectByValue("15");
		
		//Month
		WebElement obj2 = object.findElement(By.id("month"));
		Select obj3 = new Select(obj2);
		obj3.selectByValue("6");
		
		//Year
		WebElement obj4 = object.findElement(By.id("year"));
		Select obj5 = new Select(obj4);
		obj5.selectByValue("2020");
		
		
		//selecting the gender using xpath with index
		object.findElement(By.xpath("(//div[contains(text(),'Gender')]/following::span/input)[1]")).click();
		


	}

}
