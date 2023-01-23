package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartProduct1;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeCartProduct1;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    private WebElement productInCartBadge;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement cart;

    @FindBy(id = "continue-shopping")
    private WebElement continueShopping;

    public void addToCart() {
        this.addToCartProduct1.click();
    }

    public void removeToCart() {
        this.removeCartProduct1.click();
    }

    public void cartProducts() {
        this.cart.click();
    }

    public void continueShoppingButton() {
        this.continueShopping.click();
    }

    public String cartBadge() {
        return this.productInCartBadge.getText();
    }

    public String getCartValue() {
        return this.cart.getAttribute("value");
    }

    public InventoryPage(WebDriver driver) {
        super(driver);
    }
}
