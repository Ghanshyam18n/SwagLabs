package utils;

import org.openqa.selenium.*;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtils {

    public static void capture(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File dest = new File(System.getProperty("user.dir") + "/screenshots/" + name + ".png");

            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot saved at: " + dest.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}