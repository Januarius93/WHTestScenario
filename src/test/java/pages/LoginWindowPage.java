package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWindowPage extends BasePage {
    public LoginWindowPage(WebDriver driver, Actions builder) {
        super(driver, builder);
    }


    public void verifyUserNameField() {

        String userName = "login-form-username";
        isElementExist(By.id(userName));
    }

    public void verifyPasswordField() {
        String password = "login-form-password";
        isElementExist(By.id(password));
    }

    public void verifyLoginButton() {
        String loginButton = "c-login-form__submit-button";
        isElementExist(By.className(loginButton));
    }
}