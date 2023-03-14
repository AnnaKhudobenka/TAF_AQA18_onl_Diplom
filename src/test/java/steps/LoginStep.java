package steps;

import baseEntities.BaseStep;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.webdriver.UrlStartingWith;
import configuration.ReadProperties;
import io.qameta.allure.Step;
import models.User;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.visible;

public class LoginStep extends BaseStep {
    public void clearPasswordField(){
        loginPage.getPasswordInput().clear();
    }

    @Step
    public void loginSuccessful(User user){
        logger.info("In step loginSuccessful object User is using, which contains fields: " + user);
        loginPage.getUsernameInput().setValue(user.getName());
        loginPage.getPasswordInput().setValue(user.getPassword());
        loginPage.getLoginButton().click();
        dashboardPage.getAddProjectButton();
    }

    @Step
    public SelenideElement loginIncorrect(User user){
        logger.info("In step loginIncorrect object User is using, which contains fields: " + user);
        loginPage.getUsernameInput().setValue(user.getName());
        loginPage.getPasswordInput().setValue(user.getPassword());
        loginPage.getLoginButton().click();
        return loginPage.getWrongDataError();
    }

    @Step
    public SelenideElement loginWithLongPassword(User user){
        logger.info("In step loginWithLongPassword object User is using, which contains fields: " + user);
        loginPage.getUsernameInput().setValue(user.getName());
        loginPage.getPasswordInput().setValue(user.getPassword());
        loginPage.getLoginButton().click();
        return loginPage.getLongPasswordError();
    }

    @Step
    public SelenideElement loginWithShortPassword(User user){
        logger.info("In step loginWithShortPassword object User is using, which contains fields: " + user);
        loginPage.getUsernameInput().setValue(user.getName());
        loginPage.getPasswordInput().setValue(user.getPassword());
        loginPage.getLoginButton().click();
        return loginPage.getShortPasswordError();
    }
}
