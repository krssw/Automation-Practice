package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(id = "users-table-body")
    private WebElement usersTableBody;

    @FindBy(xpath = "(//*[text()= 'Add new user'])")
    private WebElement addUserLink;

    @FindBy(xpath = "(//*[text()= 'View details'])")
    private WebElement viewDetailsLink;

    @FindBy(xpath = "(//*[text()= 'Remove user'])")
    private WebElement removeUserLink;

    @FindBy(xpath = "(//*[text()= 'Update user'])")
    private WebElement updateUserLink;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage addUser() {
        addUserLink.click();
        return new MainPage(driver);
    }

    public MainPage viewDetails() {
        viewDetailsLink.click();
        return new MainPage(driver);
    }

    public MainPage removeUser() {
        removeUserLink.click();
        return new MainPage(driver);
    }

    public MainPage updateUser() {
        updateUserLink.click();
        return new MainPage(driver);
    }
}
