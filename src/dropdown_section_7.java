import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown_section_7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Invoke Browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		driver.manage().window().maximize();

		// Static Dropdown
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropDown);
		dropdown.selectByIndex(2);
		System.out.println(dropdown.getFirstSelectedOption().getText());

		// Updated Dropdown using While Loop
		Thread.sleep(3000);
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
//		int i=1;
//		while(i<3) {
//		driver.findElement(By.id("hrefIncAdt")).click();
//		i++;
//		}
//		
		// Updated Dropdown Using for loop

		for (int i = 1; i < 5; i++) {

			driver.findElement(By.id("hrefIncAdt")).click();
		}

		// Dynamic dropdown//Index or Parent child

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(3000);
		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

		Thread.sleep(5000);

		// Select calendar
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();

		// Validate UI Elements is disabled or enabled
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("It's Disabled");

		}

		// Auto Suggestive Dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//li[@class='ui-menu-item']/a[text()='India']")).click();

		// Another Way
		// Auto Suggestive Dropdown
		List<WebElement> dropdownList = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));

		for (WebElement dropdownLists : dropdownList) {

			if (dropdownLists.getText().equalsIgnoreCase("India")) {
				dropdownLists.click();
			}
		}

		// Handle checkBox in different way
		List<WebElement> allCheckboxLabels = driver.findElements(By.xpath("//div[@id='discount-checkbox']//label"));
		System.out.println(allCheckboxLabels.size());

		for (WebElement label : allCheckboxLabels) {
			if (label.getText().equalsIgnoreCase("Family and Friends")) {
				label.click();
				System.out.println(label.getSize());
				// check box selected or not
				label.isSelected();

			}
			Thread.sleep(3000);
			// Click on Searcch
			driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();

		}

		// driver.close();
	}

}
