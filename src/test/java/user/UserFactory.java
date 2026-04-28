package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(
                PropertyReader.getProperty("saucedemoo.user"),
                PropertyReader.getProperty("saucedemoo.password"));
    }

    public static User withLockedPermission() {
        return new User(
                PropertyReader.getProperty("saucedemoo.locked.user"),
                PropertyReader.getProperty("saucedemoo.password"));
    }

    public static User withIncorrectPermission() {
        return new User(
                PropertyReader.getProperty("saucedemoo.incorrect.user"),
                PropertyReader.getProperty("saucedemoo.password"));
    }

    public static User withEmptyLogin() {
        return new User("", PropertyReader.getProperty("saucedemoo.password"));
    }

    public static User withEmptyPassword() {
        return new User(PropertyReader.getProperty("saucedemoo.user"), "");
    }

    public static User withCheckoutInfo() {
        return new User(
                    PropertyReader.getProperty("saucedemoo.first.name"),
                    PropertyReader.getProperty("saucedemoo.last.name"),
                    PropertyReader.getPropertyInt("saucedemoo.postal.code"));
        }
}
