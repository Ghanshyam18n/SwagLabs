package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By checkoutBtn = By.id("checkout");

    // 👇 LOCATORS
    By cartItems = By.className("cart_item");
    By itemNames = By.className("inventory_item_name");
    By itemPrices = By.className("inventory_item_price");

    public void clickCheckout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));

        driver.findElement(checkoutBtn).click();
    }

    
    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    
    public boolean isItemDetailsDisplayed() {
        return driver.findElements(itemNames).size() > 0 &&
               driver.findElements(itemPrices).size() > 0;
    }

   
    public boolean isCorrectItemsPresent() {

        List<WebElement> items = driver.findElements(itemNames);

        boolean backpack = false;
        boolean bikeLight = false;

        for (WebElement item : items) {

            String name = item.getText();

            if (name.equals("Sauce Labs Backpack")) {
                backpack = true;
            }

            if (name.equals("Sauce Labs Bike Light")) {
                bikeLight = true;
            }
        }

        return backpack && bikeLight;
    }
}