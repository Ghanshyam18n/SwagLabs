package pages;

import org.openqa.selenium.*;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    By item1 = By.id("add-to-cart-sauce-labs-backpack");
    By item2 = By.id("add-to-cart-sauce-labs-bike-light");
    By cartIcon = By.className("shopping_cart_link");
    By cartCount = By.className("shopping_cart_badge");

    public void addProducts() {
        driver.findElement(item1).click();
        driver.findElement(item2).click();
    }

    public String getCartCount() {
        return driver.findElement(cartCount).getText();
    }

    public void openCart() {
    	
        driver.findElement(cartIcon).click();
    }
}