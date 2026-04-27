package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static org.testng.Assert.assertEquals;
import static user.UserFactory.*;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkCheckoutTitle() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart();
        productsPage.navigationPanel.cartContainerClick();
        cartPage.buttonCheckoutClick();
        assertEquals(checkoutPage.getTitle(), "Checkout: Your Information");
    }

    @Test(dataProvider = "checkout")
    public void checkout(User user) {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart();
        productsPage.navigationPanel.cartContainerClick();
        cartPage.buttonCheckoutClick();
        checkoutPage.checkout(user);
        assertEquals(checkOverviewPage.getTitle(), "Checkout: Overview");
    }

    @DataProvider(name = "checkout")
    public Object[][] checkout() {
        return new Object[][]{
                {withCheckoutInfo()},
        };
    }
}
