import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;


public class ajax_childWindows_IFrames_10 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/ref=nav_logo");
        driver.manage().window().maximize();

        // Action
        Actions a = new Actions(driver);

        a.moveToElement(driver.findElement(By.xpath("//div[@id='nav-link-accountList']"))).build().perform();

        //Put caps
        a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();

        //Right Click
        a.moveToElement(driver.findElement(By.xpath("//div[@id='nav-link-accountList']"))).contextClick().build().perform();
       // driver.close();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Windows Handle
    driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.xpath("//a[@class='blinkingText'][1]")).click();
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> iterator = allWindows.iterator();
        String currentWindow = iterator.next();
        String newWindow = iterator.next();
        driver.switchTo().window(newWindow);
        System.out.println("Current Window: " + driver.findElement(By.xpath("//a[@class='header-top-link']")).getText());
        try {
            driver.wait(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Frame
        driver.get("http://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='draggable']")));
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(source, target).perform();

    }

}
