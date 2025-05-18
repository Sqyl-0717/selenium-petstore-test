package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By signOutLink = By.xpath("//a[contains(text(),'Sign Out')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignOutVisible() {
        return driver.findElements(signOutLink).size() > 0;
    }

    public void clickSignOut() {
        driver.findElement(signOutLink).click();
    }
}
