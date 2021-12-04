package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends TestConfig {
    //Global variables
    @FindBy(xpath = "//input[@id='txtUsername']")
    public WebElement userName;
    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement passWord;
    @FindBy(id = "btnLogin")
    public WebElement loginButton;

    public LogInPage() {
        PageFactory.initElements(browser, this);
    }


}
