package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPanel {
    private WebDriver driver;
    public static final String DATA_TEST_PATTERN = "[data-test='%s']";
    private final By cartContainer = By.id("shopping_cart_container");
    private final By cartBadge = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));

    public NavigationPanel(WebDriver driver) {
        this.driver = driver;
    }

    public String checkCounterValue() {
        return driver.findElement(cartBadge).getText();
    }

    public String checkCounterColor() {
        return driver.findElement(cartBadge).getCssValue("background-color");
    }

    public void cartContainerClick() {
        driver.findElement(cartContainer).click();
    }
}
