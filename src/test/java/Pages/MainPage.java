package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

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

    //private List<User> users = new ArrayList<>();

    public void userTable(){
        List<WebElement> rows = usersTableBody.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            String name = row.findElement(By.xpath(".//td[1]")).getText();
            String email = row.findElement(By.xpath(".//td[2]")).getText();
            String position = row.findElement(By.xpath(".//td[3]")).getText();
            //users.add(new User (name, email, position));
        }
    }

    public MainPage addUser() {
        addUserLink.click();
        return this;
    }

    public MainPage viewDetails() {
        viewDetailsLink.click();
        return this;
    }

    public MainPage removeUser() {
        removeUserLink.click();
        return this;
    }

    public MainPage updateUser() {
        updateUserLink.click();
        return this;
    }
}
