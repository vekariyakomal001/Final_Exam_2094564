package SWAG_LBS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class login extends open_close_browser{

    // Here, I tried differnt 4 login credentials given on website login page
    // and finally done whole process with standard credentials
    @Test(priority = 1)
    public void locked_out_user(){
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login_btn = driver.findElement(By.id("login-button"));
        username.sendKeys("locked_out_user");
        password.sendKeys("secret_sauce");
        pauses(1);
        login_btn.click();
        pauses(1);
        WebElement error_msg = driver.findElement(By.cssSelector("button.error-button "));
        if(error_msg.isDisplayed()) {
            driver.navigate().refresh();
            pauses(1);
        }else{
            driver.navigate().back();
            pauses(1);
        }
    }

    @Test(priority = 2)
    public void problem_user(){
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login_btn = driver.findElement(By.id("login-button"));
        username.sendKeys("problem_user");
        password.sendKeys("secret_sauce");
        pauses(1);
        login_btn.click();
        pauses(1);
        driver.navigate().back();
        pauses(1);
    }

    @Test(priority = 3)
    public void performance_glitch_user(){
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login_btn = driver.findElement(By.id("login-button"));
        username.sendKeys("performance_glitch_user");
        password.sendKeys("secret_sauce");
        pauses(1);
        login_btn.click();
        pauses(1);
        driver.navigate().back();
        pauses(1);
    }

    @Test(priority = 4)
    public void standard_user(){
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login_btn = driver.findElement(By.id("login-button"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        pauses(1);
        login_btn.click();
        pauses(1);
    }
}
