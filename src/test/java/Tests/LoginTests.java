package Tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    WebDriver driver;
    LoginPage login;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        login = new LoginPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginTestInvalidPasswordStandard_User() {
        login.fillFields("standard_user", "standardUser123");
        String expectedResult = "Epic sadface: Username and password do not match any user in this service";
        String actualResult = login.getErrorMessageInvalidUserNameOrPassword();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void loginTestLocked_out_user() {
        login.fillFields("locked_out_user", "secret_sauce");
        String expectedResult = "Epic sadface: Sorry, this user has been locked out.";
        String actualResult = login.getErrorMessageUserLockedOut();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
