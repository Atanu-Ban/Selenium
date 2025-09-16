import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Practical_Prob_Method_Handle_Section_12 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        //Scroll Down
        JavascriptExecutor table = (JavascriptExecutor) driver;
        table.executeScript("window.scrollBy(0,500)");

        //Scroll Within the table
        Thread.sleep(5000);
        table.executeScript("document.querySelector('.tableFixHead').scroll(0,500);");


        //Extract Table Data and sum of all data
      List<WebElement> tdata =  driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
      int sum =0;
      for(int i=0;i<tdata.size();i++){
        sum = sum +  Integer.parseInt(tdata.get(i).getText());
      }
      System.out.println(sum);
      //Compare website data and calculated data
        String[] totalamount= driver.findElement(By.cssSelector(".totalAmount")).getText().split(": ");
       int finalamount= Integer.parseInt(totalamount[1]);
       System.out.println(finalamount);

       //Compare both Result
        Assert.assertEquals(sum,finalamount);
       if(finalamount==sum){
           System.out.println("Success");
       }

        driver.close();




    }


}
