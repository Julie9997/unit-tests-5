package seminars.five;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest2 {
    @Test
    void seleniumTest(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com");

        WebElement userNameField = webDriver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");

        WebElement passwordField = webDriver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        passwordField.submit();

        WebElement productLabel = webDriver.findElement(By.className("title"));
        String label = productLabel.getText();
        if(label.equals("Products")){
            System.out.println("Авторизация прошла успешно.");
        } else {
            System.out.println("Авторизация не прошла.");
        }

        webDriver.quit();
    }
}
