import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class end_and_end_Section_11 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.manage().window().maximize();


        //Count link on a Page
     System.out.println("Total Links: " + driver.findElements(By.tagName("a")).size());

        // Locate footer
        WebElement footer = driver.findElement(By.id("gf-BIG"));

        // Get all links inside footer
        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
        System.out.println("Footer Links: " + footerLinks.size());

        //Open all link one by one
        for(int i=0;i<footerLinks.size();i++){
            WebElement link = footerLinks.get(i);
        String clickonlinkTab=    Keys.chord(Keys.CONTROL,Keys.RETURN);
            link.sendKeys(clickonlinkTab);
            Thread.sleep(5000);
        }

        //Get title
        Set<String> LinksTitles= driver.getWindowHandles();
        Iterator <String> iterator = LinksTitles.iterator();
        while(iterator.hasNext()){
            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());
        }


    }

}
