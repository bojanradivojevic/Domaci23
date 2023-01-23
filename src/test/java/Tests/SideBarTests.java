package Tests;

import Pages.LoginPage;
import Pages.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SideBarTests {
    WebDriver driver;
    LoginPage login;
    SidebarPage sideBar;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        login = new LoginPage(driver);
        sideBar = new SidebarPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testLogout() {
        login.fillFields("standard_user", "secret_sauce");
        sideBar.clickOnTheButtonSideBar();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sideBar.clickOnTheButtonLogout();

        String expectedResult = "https://www.saucedemo.com/";
        String urlElement = driver.getCurrentUrl();
        Assert.assertEquals(urlElement, expectedResult);
    }

    @Test
    public void testUrl() {
        driver.get("https://www.saucedemo.com/inventory.html");
        String expectedResult = "Epic sadface: You can only access '/inventory.html' when you are logged in.";
        sideBar.geterrorMassegeYouCanOnlyAccessWhenYouLogin();
        String actualResult = sideBar.geterrorMassegeYouCanOnlyAccessWhenYouLogin();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
