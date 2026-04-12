package Tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {
    @Test
    public void checkCartTitle() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.cartContainerClick();
        assertEquals(cartPage.getTitle(), "Your Cart");
    }
}
