package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckOverviewPage extends BasePage {
    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By product = By.cssSelector(".inventory_item_name");
    private final By productPrice = By.cssSelector(".inventory-item-price");
    private final By paymentInfo = By.xpath("//div[@data-test = 'payment-info-value']");
    private final By shippingInfo = By.xpath("//div[@data-test = 'shipping-info-value']");
    private final By itemTotal = By.xpath("//div[@data-test = 'subtotal-label']");
    private final By tax = By.xpath("//div[@data-test = 'tax-label']");
    private final By total = By.xpath("//div[@data-test = 'tax-label']");
    private final By buttonFinish = By.id("finish");

    public CheckOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получить заголовок страницы")
    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    @Step("Получить названия продуктов")
    public ArrayList<String> getProductNameView() {
        List<WebElement> allProducts = driver.findElements(product);
        ArrayList<String> names = new ArrayList<>();

        for (WebElement product : allProducts) {
            names.add(product.getText());
        }
        return names;
    }

    @Step("Получить текст поля {paymentInfo}")
    public String getPaymentInfo() {
        return driver.findElement(paymentInfo).getText();
    }

    @Step("Получить текст поля {shippingInfo}")
    public String getShippingInfo() {
        return driver.findElement(shippingInfo).getText();
    }

    @Step("Проверить отображение итоговой суммы товаров (itemTotal)")
    public boolean itemTotalIsDisplayed() {
        return driver.findElement(itemTotal).isDisplayed();
    }

    @Step("Проверить отображение налога (tax)")
    public boolean taxIsDisplayed() {
        return driver.findElement(tax).isDisplayed();
    }

    @Step("Проверить отображение итоговой суммы товаров с налогом (total)")
    public boolean totalIsDisplayed() {
        return driver.findElement(total).isDisplayed();
    }

    @Step("Нажать на кнопку Finish")
    public void buttonFinishClick() {
        driver.findElement(buttonFinish).click();
    }
}
