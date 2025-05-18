package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.name("signon");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
