package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class CheckoutPage extends BasePage {
    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By firstNameField = By.id(("first-name"));
    private final By lastNameField = By.id(("last-name"));
    private final By postalCodeField = By.id(("postal-code"));
    private final By buttonContinue = By.id(("continue"));

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void checkout(User user) {
        fillInFirstNameField(user.getFirstName());
        fillInLastNameField(user.getLastName());
        fillInPostalCodeField(user.getPostalCode());
        driver.findElement(buttonContinue).click();
    }

    public void fillInFirstNameField(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void fillInLastNameField(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void fillInPostalCodeField(int postalCode) {
        driver.findElement(postalCodeField).sendKeys(String.valueOf(postalCode));
    }
}
