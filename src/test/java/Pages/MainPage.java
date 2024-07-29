package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[text()= 'Add new user']")
    private WebElement addUserLink;

    @FindBy(xpath = "(//*[text()= 'View details'])[1]")
    private WebElement viewDetailsLink;

    @FindBy(xpath = "(//*[text()= 'Remove user'])[3]")
    private WebElement removeUserLink;

    @FindBy(xpath = "(//*[text()= 'Update user'])[2]")
    private WebElement updateUserLink;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage clickAddUserLink() {
        addUserLink.click();
        return this;
    }

    public MainPage clickViewDetailsLink() {
        viewDetailsLink.click();
        return this;
    }

    public MainPage clickRemoveUserLink() {
        removeUserLink.click();
        return this;
    }

    public MainPage clickUpdateUserLink() {
        updateUserLink.click();
        return this;
    }
}
