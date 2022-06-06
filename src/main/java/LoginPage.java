import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;

public class LoginPage extends BasePage{
    private By loginButton = By.xpath("//*[@id=\"navbarTogglerDemo01\"]/ul[2]/li[1]/a");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By submitButton = By.xpath("//*[@id=\"app\"]/div[2]/div/form/button");
    private By logoutButton = By.xpath("//*[@id=\"navbarTogglerDemo01\"]/ul[2]/li[3]/a");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickLoginButton() {
        getDriver().findElement(loginButton).click();
    }

    public boolean isEmailFieldEnabled() {
        return getDriver().findElement(emailField).isEnabled();
    }

    public void inputEmail(String email) {
        getDriver().findElement(emailField).sendKeys(email);
    }

    public void inputPassword(String password) {
        getDriver().findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        getDriver().findElement(submitButton).click();
    }

    public boolean isLogoutButtonDisplayed() {
        return getDriver().findElement(logoutButton).isDisplayed();
    }

    public void clickLogoutButton() {
        getDriver().findElement(logoutButton).click();
    }



}
