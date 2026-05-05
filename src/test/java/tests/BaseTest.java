package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.TestListener;

import java.time.Duration;

@Listeners({AllureTestNg.class, TestListener.class})
@Owner("Марина Парфенова")
public class BaseTest {
    public WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckOverviewPage checkOverviewPage;

    @Step("Открытие браузера")
    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("headless");
            options.addArguments("guest");

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkOverviewPage = new CheckOverviewPage(driver);
    }

    @Step("Закрытие браузера")
    @AfterMethod
    public void close() {
        driver.quit();
    }
}
