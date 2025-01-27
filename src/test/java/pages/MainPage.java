package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(id = "users-table-body")
    private WebElement usersTableBody;
    @FindBy(xpath = "(//*[text()= 'Add new user'])")
    private WebElement addUserLink;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage addUser() {
        addUserLink.click();
        return new MainPage(driver);
    }

    public MainPage viewDetails(String name, String surname) {
        WebElement viewDetailsLink = driver.findElement(By.xpath(String
                .format("//tr[td[contains(text(), '%s')] and td[contains(text(), '%s')]]//td/button[contains(text(), 'View details')]", name, surname)));
        viewDetailsLink.click();
        return new MainPage(driver);
    }

    public MainPage removeUser(String name, String surname) {
        WebElement removeUserLink = driver.findElement(By.xpath(String
                .format("//tr[td[contains(text(), '%s')] and td[contains(text(), '%s')]]/td/button[contains(text(), 'Remove user')]", name, surname)));
        removeUserLink.click();
        return new MainPage(driver);
    }

    public MainPage updateUser(String name, String surname) {
        WebElement updateUserLink = driver.findElement(By.xpath(String
                .format("//tr[td[contains(text(), '%s')] and td[contains(text(), '%s')]]//td/button[contains(text(), 'Update user')]", name, surname)));
        updateUserLink.click();
        return new MainPage(driver);
    }

    public String getBodyText() {
        return driver.findElement(By.tagName("body")).getText();
    }
}
