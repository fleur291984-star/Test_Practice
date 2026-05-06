package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    private final By userField = By.cssSelector("#user-name");
    private final By passwordField = By.xpath("//*[@placeholder='Password']");
    private final By submitButton = By.cssSelector(DATA_TEST_PATTERN.formatted("login-button"));
    private final By errorMsg = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие сайта")
    public LoginPage open() {
        driver.get(BASE_URL);

        return this;
    }

    @Step("Авторизация пользователем User")
    public LoginPage login(User user) {
        fillInLoginField(user.getLogin());
        fillInPassField(user.getPassword());
        driver.findElement(submitButton).click();

        return this;
    }

    @Step("Ввести логин: {login}")
    public LoginPage fillInLoginField(String login) {
        driver.findElement(userField).sendKeys(login);

        return  this;
    }

    @Step("Ввести пароль: {password}")
    public LoginPage fillInPassField(String password) {

        driver.findElement(passwordField).sendKeys(password);

        return  this;
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
