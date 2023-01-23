package Tests;

import Pages.InventoryPage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class InventoryTests {
    WebDriver driver;
    LoginPage login;
    InventoryPage inventory;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        login = new LoginPage(driver);
        inventory = new InventoryPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void addCartBadge() {
        login.fillFields("standard_user", "secret_sauce");
        inventory.addToCart();

        String expectedResult = "1";
        String acrualResult = inventory.cartBadge();
        Assert.assertEquals(acrualResult, expectedResult);
    }

    @Test
    public void removeCartBadge() {
        login.fillFields("standard_user", "secret_sauce");
        inventory.addToCart();
        inventory.cartProducts();
        inventory.removeToCart();
        inventory.continueShoppingButton();

        String actualResult = inventory.getCartValue();
        Assert.assertEquals(actualResult, null);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

