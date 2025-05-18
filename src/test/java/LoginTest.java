package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import pages.LoginPage;

public class LoginTest {
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
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ib8g8j", "241658");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //
        wait.until(ExpectedConditions.presenceOfElementLocated(
    By.xpath("//div[@id='MenuContent']//a[contains(text(), 'Sign Out')]")
));   //complex xpath (eg. //div//a[@href='asd'])
    
        assertTrue(driver.getTitle().contains("JPetStore Demo"));

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
