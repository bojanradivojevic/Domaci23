package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidebarPage extends BasePage {

    @FindBy(id = "react-burger-menu-btn")
    private WebElement sideBar;

    @FindBy(id = "logout_sidebar_link")
    private WebElement buttonLogout;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    WebElement errorMassegeYouCanOnlyAccessWhenYouLogin;

    public void clickOnTheButtonSideBar() {
        this.sideBar.click();
    }

    public void clickOnTheButtonLogout() {
        this.buttonLogout.click();
    }

    public String geterrorMassegeYouCanOnlyAccessWhenYouLogin() {
        return this.errorMassegeYouCanOnlyAccessWhenYouLogin.getText();
    }

    public SidebarPage(WebDriver driver) {
        super(driver);
    }
}
