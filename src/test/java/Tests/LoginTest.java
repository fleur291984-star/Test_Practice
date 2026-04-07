package Tests;

import Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        LoginPage.open();
        LoginPage.login("standard_user", "secret_sauce");

        assertEquals(ProductsPage.getTitle(), "Products");
    }

    @Test
    public void checkIncorrectLogin() {
        LoginPage.open();
        LoginPage.login("locked_out_user", "secret_sauce");

        assertTrue(LoginPage.isErrorMsgDisplayed(), "The error message is failed to appear");
        LoginPage.getErrorTitle();

        assertEquals(LoginPage.getErrorTitle(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
