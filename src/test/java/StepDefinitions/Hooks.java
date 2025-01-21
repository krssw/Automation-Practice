package StepDefinitions;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import utils.TestContext;
import utils.TestContextKey;

public class Hooks {
    public WebDriver driver;
    public TestContext testContext;

    public Hooks(TestContext testContext) { this.testContext = testContext; }

        @Before
        public void setUp () {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("http://localhost:8081/index.html");
            testContext.set(TestContextKey.WEB_DRIVER, driver);
        }

}
