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
    @Step("Авторизация пользователя")
    public void loginSuccessful(User user){
        logger.info("In step loginSuccessful object User is using, which contains fields: " + user);
        loginPage.getUsernameInput().setValue(user.getName());
        loginPage.getPasswordInput().setValue(user.getPassword());
        loginPage.getLoginButton().click();
        dashboardPage.getAddProjectButton();
    }
    @Step("Авторизация пользователя с некорректными данными")
    public SelenideElement loginIncorrect(User user){
        logger.info("In step loginIncorrect object User is using, which contains fields: " + user);
        loginPage.getUsernameInput().setValue(user.getName());
        loginPage.getPasswordInput().setValue(user.getPassword());
        loginPage.getLoginButton().click();
        return loginPage.getWrongDataError();
    }
    @Step("Авторизация пользователя с паролем, превышающим допустимое количество символов")
    public SelenideElement loginWithLongPassword(User user){
        logger.info("In step loginWithLongPassword object User is using, which contains fields: " + user);
        loginPage.getUsernameInput().setValue(user.getName());
        loginPage.getPasswordInput().setValue(user.getPassword());
        loginPage.getLoginButton().click();
        return loginPage.getLongPasswordError();
    }
    @Step("Авторизация пользователя с паролем, меньше допустимого количества символов")
    public SelenideElement loginWithShortPassword(User user){
        logger.info("In step loginWithShortPassword object User is using, which contains fields: " + user);
        loginPage.getUsernameInput().setValue(user.getName());
        loginPage.getPasswordInput().setValue(user.getPassword());
        loginPage.getLoginButton().click();
        return loginPage.getShortPasswordError();
    }
}
