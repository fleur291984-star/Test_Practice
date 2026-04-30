package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

@Epic("Покупательский цикл")
public class ProductsTest extends BaseTest {
    List<String> goodsList =
            List.of("Sauce Labs Onesie",
                    "Sauce Labs Bolt T-Shirt",
                    "Sauce Labs Bike Light");

    @Feature("Корзина")
    @Story("Массовое добавление товаров и проверка счетчика")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertTrue(productsPage.pageTitleDisplayed());
        assertEquals(productsPage.getGoodsQuantity(), 6);
        productsPage.addToCart();
        for (String goods : goodsList) {
            productsPage.addToCart(goods);
        }
        assertEquals(productsPage.navigationPanel.checkCounterValue(), "4");
        assertEquals(productsPage.navigationPanel.checkCounterColor(), "rgba(226, 35, 26, 1)");
        productsPage.navigationPanel.cartContainerClick();
    }
}
