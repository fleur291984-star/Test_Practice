package user;

import utils.PropertyReader;

public class UserFactory {

    public static User withAdminPermission() {
        return User.builder()
                .login(PropertyReader.getProperty("saucedemoo.user"))
                .password(PropertyReader.getProperty("saucedemoo.password"))
                .build();
    }

    public static User withLockedPermission() {
        return User.builder()
                .login(PropertyReader.getProperty("saucedemoo.locked.user"))
                .password(PropertyReader.getProperty("saucedemoo.password"))
                .build();
    }

    public static User withIncorrectPermission() {
        return User.builder()
                .login(PropertyReader.getProperty("saucedemoo.incorrect.user"))
                .password(PropertyReader.getProperty("saucedemoo.password"))
                .build();
    }

    public static User withEmptyLogin() {
        return User.builder()
                .login("")
                .password(PropertyReader.getProperty("saucedemoo.password"))
                .build();
    }

    public static User withEmptyPassword() {
        return User.builder()
                .login(PropertyReader.getProperty("saucedemoo.user"))
                .password( "")
                .build();
    }

    public static User withCheckoutInfo() {
        return User.builder()
                .firstName(PropertyReader.getProperty("saucedemoo.first.name"))
                .lastName(PropertyReader.getProperty("saucedemoo.last.name"))
                .postalCode(PropertyReader.getProperty("saucedemoo.postal.code"))
                .build();
    }

    public static User withEmptyFirstName() {
        return User.builder()
                .firstName("")
                .lastName( PropertyReader.getProperty("saucedemoo.last.name"))
                .postalCode(PropertyReader.getProperty("saucedemoo.postal.code"))
                .build();
    }

    public static User withEmptyLastName() {
        return User.builder()
                .firstName(PropertyReader.getProperty("saucedemoo.first.name"))
                .lastName("")
                .postalCode(PropertyReader.getProperty("saucedemoo.postal.code"))
                .build();
    }

    public static User withEmptyPostalCode() {
        return User.builder()
                .firstName(PropertyReader.getProperty("saucedemoo.first.name"))
                .lastName(PropertyReader.getProperty("saucedemoo.last.name"))
                .postalCode( "")
                .build();
    }
}
