package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.HomePage;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class LogoutTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
    }

    @Test
    public void testLogout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ib8g8j", "241658");

        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isSignOutVisible());

        homePage.clickSignOut();

        assertFalse(driver.getPageSource().contains("Sign Out"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
