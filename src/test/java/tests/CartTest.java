package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {
    final String goodsName = "Sauce Labs Bolt T-Shirt";

    @Test
    public void checkCartTitle() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.navigationPanel.cartContainerClick();
        assertEquals(cartPage.getTitle(), "Your Cart");
    }

    @Test
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(goodsName);
        productsPage.navigationPanel.cartContainerClick();
        assertFalse(cartPage.getProductNames().isEmpty());
        assertEquals(cartPage.getProductNames().size(), 1);
        assertTrue(cartPage.getProductNames().contains(goodsName));
    }
}
