package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.Keys.ENTER;

public class AddUserPage extends BasePage {
    
    @FindBy(id = "name")
    private WebElement nameField;
    @FindBy(id = "surname")
    private WebElement surnameField;
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "position")
    private WebElement positionField;
    @FindBy(id = "create-user-button")
    private WebElement createUserButton;

    public AddUserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AddUserPage eraseData() {
        nameField.clear();
        surnameField.clear();
        emailField.clear();
        return new AddUserPage(driver);
    }

    public AddUserPage addNewUser(String name, String surname, String email, String position) {
        nameField.sendKeys(name);
        surnameField.sendKeys(surname);
        emailField.sendKeys(email);
        positionField.sendKeys(position);
        nameField.click();
        return new AddUserPage(driver);
    }

    public AddUserPage confirmUserCreation() {
        createUserButton.sendKeys(ENTER);
        return new AddUserPage(driver);
    }
}