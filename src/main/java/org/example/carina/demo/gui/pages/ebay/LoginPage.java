package org.example.carina.demo.gui.pages.ebay;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "userid")
    ExtendedWebElement usernameBox;
    @FindBy(id = "pass")
    ExtendedWebElement passwordBox;
    @FindBy(id = "signin-continue-btn")
    ExtendedWebElement continueButton;
    @FindBy(css = "#signin-error-msg")
    ExtendedWebElement errorMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickUsernameBox(String username){
        sendKeys(usernameBox, username);
    }
    public void clickPasswordBox(String password){
        sendKeys(passwordBox, password);
    }
    public void clickContinueButton(){
        click(continueButton);
    }
    public String getErrorMsg(){
        return errorMsg.getText();
    }
}
