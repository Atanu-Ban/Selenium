import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class locator_Section_5_6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("Test@123");
		driver.findElement(By.className("signInBtn")).click();
		String errorText = driver.findElement(By.className("error")).getText();
		// System.out.println(errorText);
		if (errorText.equals("* Incorrect username or password")) {
			driver.findElement(By.linkText("Forgot your password?")).click();
		}

		else {
			System.out.println("Not Match");
		}
		// Forgot Password//signup		
			driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rahul");
			driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("rahul@gmail.com");
			driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("7003018854");
			driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		    String infoMessage =driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
           String[] infomsg= infoMessage.split("'");
           String tempPassword= infomsg[1].trim();
           
           driver.findElement(By.className("go-to-login-btn")).click();
   		  driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
  		 driver.findElement(By.name("inputPassword")).sendKeys(tempPassword);
 		driver.findElement(By.className("signInBtn")).click();
        //driver.close();
  		 

	}

}
