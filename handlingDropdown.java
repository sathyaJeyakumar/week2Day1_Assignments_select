package week2Day1_assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class handlingDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		
		//opening the url 
		driver.get("http://leaftaps.com/opentaps/");
		
		//maximising the window
		driver.manage().window().maximize();
		
			
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestCompanyName");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("TestFirstName");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("TestLastName");
		
		Select sourceDropdown = new Select(driver.findElement(By.id("createLeadForm_dataSourceId")));
		sourceDropdown.selectByIndex(4);
		
		Select mrkCmpDropdown = new Select(driver.findElement(By.id("createLeadForm_marketingCampaignId")));
		mrkCmpDropdown.selectByVisibleText("Automobile");
		
		
		Select ownershipDropdown = new Select(driver.findElement(By.id("createLeadForm_ownershipEnumId")));
		ownershipDropdown.selectByValue("OWN_CCORP");
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.name("submitButton")).click();
		System.out.println(driver.getTitle());
		if (driver.getTitle().equals("View Lead | opentaps CRM") ) 
		{
			System.out.println("Create lead succesfully");
		}
		
		

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}

}
