package SWAG_LBS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class open_close_browser {

    public static WebDriver driver;
    public static String base_URL;

    //Open Chrome Browser and redirect to particular website link
    //Here, I handled window size
    @BeforeTest
    public void open_browser_handling(){
        driver = new ChromeDriver();
        base_URL = "https://www.saucedemo.com/";
        driver.get(base_URL);
        driver.manage().window().maximize();
        pauses(2);
    }

    public static void pauses(int i){
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //close current window
    @AfterTest
    public void close_browser_handling(){
        pauses(2);
        driver.close();
    }
}
