import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Wait_Section_9 {

    public static void main(String[] args) throws InterruptedException {





        // Invoke Browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //Implicit Wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        String[] listVeg = {"Brocolli", "Beans"};
        List<String> listOfItem = Arrays.asList(listVeg);

        // Get all products
        List<WebElement> getAllProduct = driver.findElements(By.xpath("//h4[@class='product-name']"));

        for (int i = 0; i < getAllProduct.size(); i++) {

            String[] products = getAllProduct.get(i).getText().split("-");
            String formattedName = products[0].trim();

            // Check product match or not
            if (listOfItem.contains(formattedName)) {
                // Click on Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
            }

            driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
            driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
            driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahul");

            driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
            System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());

        }

       // driver.quit();
    }

}
