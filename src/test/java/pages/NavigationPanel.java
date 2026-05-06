package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.BasePage.DATA_TEST_PATTERN;

public class NavigationPanel {
    private WebDriver driver;
    private final By cartContainer = By.id("shopping_cart_container");
    private final By cartBadge = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));

    public NavigationPanel(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверить количество товаров на иконке корзины")
    public String checkCounterValue() {
        return driver.findElement(cartBadge).getText();
    }

    @Step("Проверить цвет фона иконки корзины")
    public String checkCounterColor() {
        return driver.findElement(cartBadge).getCssValue("background-color");
    }

    @Step("Нажать на элемент cartContainer")
    public NavigationPanel cartContainerClick() {
        driver.findElement(cartContainer).click();

        return  this;
    }
}
