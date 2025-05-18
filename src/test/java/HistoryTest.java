package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import pages.LoginPage;
import pages.HomePage;

public class HistoryTest {
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
    public void testBackNavigation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ib8g8j", "241658");

        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isSignOutVisible());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[img[contains(@src, 'sm_dogs.gif')]]"))
        ).click();


        driver.navigate().back();


        assertTrue(driver.getPageSource().contains("Sign Out"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
