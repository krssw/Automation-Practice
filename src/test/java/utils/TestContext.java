package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestContext {
    public WebDriver driver;

    public TestContext() {
        this.driver = new ChromeDriver();
    }
}
