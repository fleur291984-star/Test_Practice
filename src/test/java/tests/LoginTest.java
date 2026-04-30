package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

@Epic("Авторизация")
public class LoginTest extends BaseTest {

    @Feature("Вход в систему")
    @Story("Успешный вход под администратором")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertEquals(productsPage.getTitle(), "Products");
    }

    @Feature("Вход в систему")
    @Story("Валидация полей при входе")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "incorrectData")
    public void checkIncorrectLogin(User user, String errorMSG) {
        loginPage.open();
        loginPage.login(user);
        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message is failed to appear");
        assertEquals(loginPage.getErrorTitle(), errorMSG);
    }

    @DataProvider(name = "incorrectData")
    public Object[][] login() {
        return new Object[][]{
                {withLockedPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {withEmptyLogin(), "Epic sadface: Username is required"},
                {withEmptyPassword(), "Epic sadface: Password is required"},
                {withIncorrectPermission(), "Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
