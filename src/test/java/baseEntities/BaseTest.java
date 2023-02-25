package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import steps.LoginStep;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected LoginStep loginStep;
    protected User userSuccessful;
    protected User userIncorrect;
    protected User userWithLongPassword;
    @BeforeSuite
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 15000;
        Configuration.fastSetValue = true;
        loginStep = new LoginStep();
        userSuccessful = User.builder()
                .name("annaavinova@gmail.com")
                .password("Qwertyu_1")
                .build();
        userIncorrect = User.builder()
                .name("andrewmrz@gmail.com")
                .password("Qwerty_123456789")
                .build();
        userWithLongPassword = User.builder()
                .name("annaavinova@gmail.com")
                .password("paaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaassssssssssssssssssswooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooord")
                .build();
        open("");
    }
    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
