import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class deep_drive_funtional_testing_8 {

    public static void main(String[] args) throws InterruptedException {

        // Invoke Browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().window().maximize();
        Thread.sleep(5000);

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
        }

        driver.quit();
    }
}
