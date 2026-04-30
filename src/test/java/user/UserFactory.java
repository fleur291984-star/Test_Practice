package user;

import io.qameta.allure.Step;
import utils.PropertyReader;

public class UserFactory {

    @Step("Подготовить данные администратора из конфига")
    public static User withAdminPermission() {
        return new User(
                PropertyReader.getProperty("saucedemoo.user"),
                PropertyReader.getProperty("saucedemoo.password"));
    }

    @Step("Подготовить данные заблокированного пользователя")
    public static User withLockedPermission() {
        return new User(
                PropertyReader.getProperty("saucedemoo.locked.user"),
                PropertyReader.getProperty("saucedemoo.password"));
    }

    @Step("Подготовить данные несуществующего пользователя")
    public static User withIncorrectPermission() {
        return new User(
                PropertyReader.getProperty("saucedemoo.incorrect.user"),
                PropertyReader.getProperty("saucedemoo.password"));
    }

    @Step("Подготовить данные пользователя с пустым полем логин")
    public static User withEmptyLogin() {
        return new User("", PropertyReader.getProperty("saucedemoo.password"));
    }

    @Step("Подготовить данные пользователя с пустым полем пароль")
    public static User withEmptyPassword() {
        return new User(PropertyReader.getProperty("saucedemoo.user"), "");
    }

    @Step("Подготовить персональные данные для оформления заказа")
    public static User withCheckoutInfo() {
        return new User(
                PropertyReader.getProperty("saucedemoo.first.name"),
                PropertyReader.getProperty("saucedemoo.last.name"),
                PropertyReader.getProperty("saucedemoo.postal.code"));
    }

    @Step("Подготовить данные пользователя с пустым полем Имя")
    public static User withEmptyFirstName() {
        return new User("", PropertyReader.getProperty("saucedemoo.last.name"),
                PropertyReader.getProperty("saucedemoo.postal.code"));
    }

    @Step("Подготовить данные пользователя с пустым полем Фамилия")
    public static User withEmptyLastName() {
        return new User(PropertyReader.getProperty("saucedemoo.first.name"),
                "", PropertyReader.getProperty("saucedemoo.postal.code"));
    }

    @Step("Подготовить данные пользователя с пустым полем Индекс")
    public static User withEmptyPostalCode() {
        return new User(PropertyReader.getProperty("saucedemoo.first.name"),
                PropertyReader.getProperty("saucedemoo.last.name"), "");
    }
}
