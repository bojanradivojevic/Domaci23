package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement errorMessageInvalidUserNameOrPassword;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement errorMessageUserLockedOut;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getErrorMessageInvalidUserNameOrPassword() {
        return this.errorMessageInvalidUserNameOrPassword.getText();
    }

    public String getErrorMessageUserLockedOut() {
        return this.errorMessageUserLockedOut.getText();
    }

    public void fillFields(String userName, String password) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
