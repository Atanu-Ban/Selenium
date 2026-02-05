import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Miscellaneous_topics_13 {

    public static void main(String[] args) throws IOException, URISyntaxException {

        //Handaling HTTP Certification
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        //Handaling Proxy
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        options.setCapability("proxy", proxy);

        //Set Path
        Map<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", "/directory/path");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        //Maximize Window
        driver.manage().window().maximize();
        //Delete All Cookies
        driver.manage().deleteAllCookies();
        //Delete Specific cookies
        driver.manage().deleteCookieNamed("JSESSIONID");

        //Take a Screenshot
        File Src= ((TakesScreenshot)driver).getScreenshotAs((OutputType.FILE));
        FileUtils.copyFile(Src,new File("D://screenshot.png"));

        //Broken Link
        //Step 1 = Is to get all urls tied up to the links using selenium
        //Java method's will call URL's and gets you the status code
        //If status code >400 then that url is broken
        //'a[href*="soapui"]

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

// Single link check
        String url = driver.findElement(By.cssSelector("a[href*='soapui']"))
                .getAttribute("href");

        HttpURLConnection conn =
                (HttpURLConnection) new URI(url).toURL().openConnection();

        conn.setRequestMethod("HEAD");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        conn.connect();

        int responseCode = conn.getResponseCode();
        System.out.println("SoapUI link --> " + responseCode);

// Verify all footer links
        List<WebElement> links =
                driver.findElements(By.cssSelector("li.gf-li a"));

        SoftAssert a = new SoftAssert();

        for (WebElement link : links) {

            String url1 = link.getAttribute("href");

            try {
                HttpURLConnection connt =
                        (HttpURLConnection) new URI(url1).toURL().openConnection();

                connt.setRequestMethod("HEAD");
                connt.setConnectTimeout(5000);
                connt.setReadTimeout(5000);
                connt.connect();

                int respCode = connt.getResponseCode();
                System.out.println(link.getText() + " --> " + respCode);

                a.assertTrue(respCode < 400,
                        "❌ Broken link: " + link.getText()
                                + " | URL: " + url1
                                + " | Code: " + respCode);

            } catch (Exception e) {
                a.fail("❌ Exception for link: " + link.getText()
                        + " | URL: " + url1
                        + " | Error: " + e.getMessage());
            }
        }

        a.assertAll();
       }

    }

