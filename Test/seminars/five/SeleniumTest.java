package seminars.five;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {

    @Test
    void testOpenSite() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com/");
        WebElement webElement = webDriver.findElement(By.name("q"));
        webElement.sendKeys("Selenium");
        webElement.submit();
        WebElement res = webDriver.findElement(By.className("tjvcx"));

        boolean found = false;
        if (res.getText().contains("selenium.dev"))
            found = true;

        assertTrue(found);
        webDriver.quit();
    }
}
