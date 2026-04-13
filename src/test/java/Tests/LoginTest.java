package Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getTitle(), "Products");
    }

    @Test(dataProvider = "incorrectData")
    public void checkIncorrectLogin(String user, String password, String errorMSG) {
        loginPage.open();
        loginPage.login(user, password);

        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message is failed to appear");
        assertEquals(loginPage.getErrorTitle(), errorMSG);
    }

    @DataProvider(name = "incorrectData")
    public Object[][] login() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"Standard_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
