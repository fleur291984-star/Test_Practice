package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class CartTest extends BaseTest {
    final String goodsName = "Sauce Labs Bolt T-Shirt";

    @Test
    public void checkCartTitle() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.navigationPanel.cartContainerClick();
        assertEquals(cartPage.getTitle(), "Your Cart");
    }

    @Test
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart(goodsName);
        productsPage.navigationPanel.cartContainerClick();
        assertFalse(cartPage.getProductNames().isEmpty());
        assertEquals(cartPage.getProductNames().size(), 1);
        assertTrue(cartPage.getProductNames().contains(goodsName));
        cartPage.buttonCheckoutClick();
    }
}
