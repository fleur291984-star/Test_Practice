package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By product = By.cssSelector(".inventory_item_name");
    private final By elementsWait = By.id("continue-shopping");
    private final By buttonCheckout = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получить заголовок страницы")
    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    @Step("Получить названия продуктов")
    public ArrayList<String> getProductNames() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementsWait));
        List<WebElement> allProducts = driver.findElements(product);
        ArrayList<String> names = new ArrayList<>();

        for (WebElement product : allProducts) {
            names.add(product.getText());
        }
        return names;
    }

    @Step("Нажать кнопку 'Checkout'")
    public void buttonCheckoutClick() {
        driver.findElement(buttonCheckout).click();
    }
}
