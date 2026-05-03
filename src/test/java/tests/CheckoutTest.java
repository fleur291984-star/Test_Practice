package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

@Epic("Покупательский цикл")
public class CheckoutTest extends BaseTest {

    @Feature("Оформление заказа (Checkout)")
    @Story("Переход к заполнению информации о клиенте")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void checkCheckoutTitle() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart();
        productsPage.navigationPanel.cartContainerClick();
        cartPage.buttonCheckoutClick();
        assertEquals(checkoutPage.getTitle(), "Checkout: Your Information");
    }

    @Feature("Оформление заказа (Checkout)")
    @Story("Успешный ввод данных и переход к обзору заказа")
    @Severity(SeverityLevel.CRITICAL)
    @Test()
    public void checkout() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart();
        productsPage.navigationPanel.cartContainerClick();
        cartPage.buttonCheckoutClick();
        checkoutPage.checkout(withCheckoutInfo());
        assertEquals(checkOverviewPage.getTitle(), "Checkout: Overview");
    }

    @Feature("Оформление заказа (Checkout)")
    @Story("Валидация полей формы оплаты")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "incorrectCheckout")
    public void incorrectCheckout(User user, String errorMSG) {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart();
        productsPage.navigationPanel.cartContainerClick();
        cartPage.buttonCheckoutClick();
        checkoutPage.checkout(user);
        assertTrue(checkoutPage.isErrorMsgDisplayed(), "The error message is failed to appear");
        assertEquals(checkoutPage.getErrorTitle(), errorMSG);
    }

    @DataProvider(name = "incorrectCheckout")
    public Object[][] incorrectCheckout() {
        return new Object[][]{
                {withEmptyFirstName(), "Error: First Name is required"},
                {withEmptyLastName(), "Error: Last Name is required"},
                {withEmptyPostalCode(), "Error: Postal Code is required"},
        };
    }
}
