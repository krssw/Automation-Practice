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

    public void clickAddUserLink() {
        addUserLink.click();
    }

    public void clickViewDetailsLink() {
        viewDetailsLink.click();
    }

    public void clickRemoveUserLink() {
        removeUserLink.click();
    }

    public void clickUpdateUserLink() {
        updateUserLink.click();
    }
}
