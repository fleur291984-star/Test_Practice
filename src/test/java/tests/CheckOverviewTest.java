package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;
import static user.UserFactory.withCheckoutInfo;

@Epic("Покупательский цикл")
public class CheckOverviewTest extends BaseTest {
    final String goodsName = "Sauce Labs Backpack";

    @Feature("Оформление заказа (Checkout)")
    @Story("Проверка сводной информации по заказу (Overview)")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void checkGoodsOverview() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart(goodsName);
        productsPage.navigationPanel.cartContainerClick();
        cartPage.buttonCheckoutClick();
        checkoutPage.checkout(withCheckoutInfo());
        assertTrue(checkOverviewPage.getProductNameView().contains(goodsName));
        assertEquals(checkOverviewPage.getPaymentInfo(), "SauceCard #31337");
        assertEquals(checkOverviewPage.getShippingInfo(), "Free Pony Express Delivery!");
        assertTrue(checkOverviewPage.itemTotalIsDisplayed());
        assertTrue(checkOverviewPage.taxIsDisplayed());
        assertTrue(checkOverviewPage.totalIsDisplayed());
        checkOverviewPage.buttonFinishClick();
    }
}
