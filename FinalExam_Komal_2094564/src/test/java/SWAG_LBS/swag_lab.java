package SWAG_LBS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class swag_lab extends open_close_browser{

    @Test(priority = 5)
    public void filter_and_product_description() {
        Select filter_product = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        filter_product.selectByValue("lohi");
        pauses(3);

        List<WebElement> products = driver.findElements(By.cssSelector("div.inventory_item_name"));
        //Go to description page of one product
        WebElement item_detail = driver.findElement(By.xpath("//div[@class='inventory_item'][1]//div[@class='inventory_item_name']"));
        item_detail.click();
        pauses(2);

        //add item to the cart from product description
        WebElement inner_add_to_cart = driver.findElement(By.xpath("//button[contains(@class,'btn_inventory')]"));
        inner_add_to_cart.click();
        pauses(2);

        //Go back to product list page
        WebElement back_to_list = driver.findElement(By.xpath("//button[@name='back-to-products']"));
        back_to_list.click();
        pauses(2);
    }

    @Test(priority = 7)
    public void add_product_to_cart() {
        List<WebElement> products = driver.findElements(By.cssSelector("div.inventory_item_name"));
        //loop for all the products
        for (int i = 1; i < products.size(); i++) {
            //add products to the cart one by one
            driver.findElements(By.xpath("//button[contains(@class,'btn_inventory')]")).get(i).click();
            pauses(3);
        }

        //To scroll page up
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        pauses(4);
    }

    @Test(priority = 8)
    public void cart() {

        //click on cart button
        WebElement add_to_cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        add_to_cart.click();
        pauses(2);
    }

    @Test(priority = 9)
    public void remove_item_from_cart() {
        //Remove item from cart
        WebElement remove_button = driver.findElement(By.xpath("//div[@class='cart_item'][1]//button[contains(@class,'cart_button')]"));
        remove_button.click();
        pauses(2);

        //To scroll page down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        pauses(4);

        //click on continue shopping for again add some items to the cart
        WebElement continue_shopping = driver.findElement(By.id("continue-shopping"));
        continue_shopping.click();
        pauses(2);

        //To scroll page up
        js.executeScript("window.scrollBy(0,-500)");
        pauses(4);

        //again click on cart button
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        pauses(2);
    }

    @Test(priority = 10)
    public void checkout() {

        //To scroll page down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        pauses(4);

        //do checkout
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        pauses(2);

        //To scroll page up
        js.executeScript("window.scrollBy(0,-300)");
        pauses(4);

        //cancel checkout if you want to add any product
        driver.findElement(By.xpath("//button[@name='cancel']")).click();
        pauses(2);

        //To scroll page up
        js.executeScript("window.scrollBy(0,-200)");
        pauses(4);

        //Remove item from cart
        WebElement remove_button = driver.findElement(By.xpath("//div[@class='cart_item'][2]//button[contains(@class,'cart_button')]"));
        remove_button.click();
        pauses(2);

        //To scroll page down
        js.executeScript("window.scrollBy(0,400)");
        pauses(4);

        //again do checkout
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        pauses(2);
    }

    @Test(priority = 11)
    public void registration() {

        //To scroll page up
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-300)");
        pauses(4);

        //continue checkout
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        pauses(2);

        //Fill some details for checkout
        WebElement fname = driver.findElement(By.xpath("//input[@id='first-name']"));
        fname.sendKeys("Komal");
        pauses(2);

        WebElement lname = driver.findElement(By.xpath("//input[@id='last-name']"));
        lname.sendKeys("Vekariya");
        pauses(2);

        WebElement postal_code = driver.findElement(By.xpath("//input[@id='postal-code']"));
        postal_code.sendKeys("H4P1C7");
        pauses(2);

        //continue checkout
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        pauses(2);
    }

    @Test(priority = 12)
    public void finish_process() {

        //To scroll page down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        pauses(4);

        //finish whole process of purchasing products
        driver.findElement(By.name("finish")).click();
        pauses(2);

        //go to the home page
        driver.findElement(By.id("back-to-products")).click();
        pauses(2);
    }

    @Test(priority = 13)
    public void logout() {
        //click on side menu
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        pauses(2);

        //do logout
        driver.findElement(By.id("logout_sidebar_link")).click();
        pauses(2);
    }
}
