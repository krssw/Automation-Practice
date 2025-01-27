package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeOptions;
import utils.TestContext;
import utils.TestContextKey;

public class Hooks {
    public WebDriver driver;
    public TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before()
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
//      options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:8081/index.html");
        testContext.set(TestContextKey.WEB_DRIVER, driver);
        driver.manage();
    }

    @After()
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
