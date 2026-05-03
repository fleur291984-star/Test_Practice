package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CART_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By addToCartButton = By.xpath("//*[text() = 'Add to cart']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получить заголовок страницы")
    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    @Step("Нажать на кнопку addToCart")
    public void addToCart() {
        driver.findElements(addToCartButton).get(0).click();
    }

    @Step("Подсчитать количество товаров на странице")
    public int getGoodsQuantity() {
        return driver.findElements(addToCartButton).size();
    }

    @Step("Добавить товар '{goodsName}' в корзину")
    public void addToCart(final String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    @Step("Получить заголовок страницы")
    public boolean pageTitleDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }
}
