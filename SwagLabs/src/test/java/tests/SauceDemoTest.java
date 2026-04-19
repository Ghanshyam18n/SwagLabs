package tests;

import org.testng.annotations.Listeners;
import utils.TestListener;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

@Listeners(TestListener.class)
public class SauceDemoTest extends BaseTest {

    @Test
    public void testOrderFlow() {

        System.out.println("Launching application");

        LoginPage login = new LoginPage(driver);
        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        System.out.println("Logging in");
        login.login("standard_user", "secret_sauce");

        System.out.println("Verifying login successful");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

        System.out.println("Adding products to cart");
        products.addProducts();

        System.out.println("Verifying cart count");
        String count = products.getCartCount();
        System.out.println("Cart count is: " + count);

        Assert.assertEquals(count, "2");

        System.out.println("Opening cart page");
        products.openCart();
        System.out.println("Validating cart items");

     
     Assert.assertEquals(cart.getCartItemCount(), 2);

     
     Assert.assertTrue(cart.isCorrectItemsPresent());

     
     Assert.assertTrue(cart.isItemDetailsDisplayed());

     System.out.println("Validating item prices");

  
  Assert.assertTrue(driver.getPageSource().contains("$29.99"));
  Assert.assertTrue(driver.getPageSource().contains("$9.99"));

     System.out.println("Proceeding to checkout");
     cart.clickCheckout();

        System.out.println("Entering user details");
        checkout.enterDetails();

        System.out.println("Finishing order");
        checkout.finishOrder();

        System.out.println("Verifying success message");
        Assert.assertEquals(
                checkout.getSuccessMessage(),
                "Thank you for your order!"
        );

        System.out.println("Test completed successfully");
    }
}