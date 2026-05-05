package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class CheckoutPage extends BasePage {
    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By firstNameField = By.id(("first-name"));
    private final By lastNameField = By.id(("last-name"));
    private final By postalCodeField = By.id(("postal-code"));
    private final By buttonContinue = By.id(("continue"));
    private final By errorMsg = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получить заголовок страницы")
    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    @Step("Заполнить форму Checkout и нажать Continue")
    public CheckoutPage checkout(User user) {
        fillInFirstNameField(user.getFirstName());
        fillInLastNameField(user.getLastName());
        fillInPostalCodeField(user.getPostalCode());
        driver.findElement(buttonContinue).click();

        return this;
    }

    @Step("Ввести имя: {firstName}")
    public void fillInFirstNameField(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    @Step("Ввести фамилию: {lastName}")
    public void fillInLastNameField(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    @Step("Ввести почтовый индекс: {postalCode}")
    public void fillInPostalCodeField(String postalCode) {
        driver.findElement(postalCodeField).sendKeys(String.valueOf(postalCode));
    }

    @Step("Проверить отображение сообщения об ошибке")
    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }

   @Step("Получить текст ошибки")
    public String getErrorTitle() {
        return driver.findElement(errorMsg).getText();
   }
}
