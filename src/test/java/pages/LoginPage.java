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
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Авторизация пользователем User")
    public void login(User user) {
        fillInLoginField(user.getLogin());
        fillInPassField(user.getPassword());
        driver.findElement(submitButton).click();
    }

    @Step("Ввести логин: {login}")
    public void fillInLoginField(String login) {
        driver.findElement(userField).sendKeys(login);
    }

    @Step("Ввести пароль: {password}")
    public void fillInPassField(String password) {
        driver.findElement(passwordField).sendKeys(password);
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
