package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver=driver;
    }

    By addUserLink = By.xpath("//a[@class='btn btn-success']");
    By viewDetailsLink = By.xpath("//*[@id=\"users-table-body\"]/tr[1]/td[4]/button[1]");
    By removeUserLink = By.xpath("//*[@id=\"users-table-body\"]/tr[3]/td[4]/button[3]");
    By updateUserLink = By.xpath("//*[@id=\"users-table-body\"]/tr[2]/td[4]/button[2]");

    public void clickAddUserLink(){
        driver.findElement(addUserLink).click();
    }

    public void clickViewDetailsLink(){
        driver.findElement(viewDetailsLink).click();
    }

    public void clickRemoveUserLink(){
        driver.findElement(removeUserLink).click();
    }

    public void clickUpdateUserLink(){
        driver.findElement(updateUserLink).click();
    }
}