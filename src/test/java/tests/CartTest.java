package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static enums.TitleNaming.CART;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Epic("Покупательский цикл")
public class CartTest extends BaseTest {
    final String goodsName = "Sauce Labs Bolt T-Shirt";

    @Feature("Корзина")
    @Story("Проверка названия страницы корзины")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("Test_Practice")
    @Issue("fleur291984-star")
    @Test
    public void checkCartTitle() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.navigationPanel.cartContainerClick();
        assertEquals(cartPage.getTitle(), CART.getDisplayName());
    }

    @Feature("Корзина")
    @Story("Добавление и проверка товара в корзине")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void checkGoodsInCart() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage
                .addToCart(goodsName)
                .navigationPanel.cartContainerClick();
        assertFalse(cartPage.getProductNames().isEmpty());
        assertEquals(cartPage.getProductNames().size(), 1);
        assertTrue(cartPage.getProductNames().contains(goodsName));
        cartPage.buttonCheckoutClick();
    }
}
