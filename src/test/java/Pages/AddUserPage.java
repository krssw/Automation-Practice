package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AddUserPage {
  WebDriver driver;

  public AddUserPage(WebDriver driver){
    this.driver=driver;
  }

  By nameField = By.id("name");
  By surnameField = By.id("surname");
  By emailField = By.id("email");
  By positionField = By.id("position");
  By createUserButton = By.xpath("//button[@class='btn btn-success']");

  public void eraseData (){
    driver.findElement(nameField).clear();
    driver.findElement(surnameField).clear();
    driver.findElement(emailField).clear();
  }

  public void addNewUser(String name, String surname, String email, String position) {
    driver.findElement(nameField).sendKeys(name);
    driver.findElement(surnameField).sendKeys(surname);
    driver.findElement(emailField).sendKeys(email);
    driver.findElement(positionField).sendKeys(position);
  }

  public void confirmUserCreation() {
    driver.findElement(createUserButton).sendKeys(Keys.ENTER);
  }
}