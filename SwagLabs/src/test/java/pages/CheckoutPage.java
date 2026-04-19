package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By zip = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By successMsg = By.className("complete-header");

    public void enterDetails() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));

        driver.findElement(firstName).sendKeys("Ghanshyam");
        driver.findElement(lastName).sendKeys("Sharma");
        driver.findElement(zip).sendKeys("841203");
    }

    public void finishOrder() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(continueBtn).click();

        wait.until(ExpectedConditions.urlContains("checkout-step-two"));

        wait.until(ExpectedConditions.elementToBeClickable(finishBtn));
        driver.findElement(finishBtn).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }
}