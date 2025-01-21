package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDetailsPage extends BasePage {

    @FindBy(xpath = "(//*[text()= 'Update user'])")
    private WebElement updateUserButton;

    public UserDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public UserDetailsPage updateUserDetails() {
        updateUserButton.click();
        return new UserDetailsPage(driver);
    }
}
