package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;


import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import models.Project;
import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.DashboardStep;
import steps.LoginStep;
import steps.ProjectStep;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected LoginStep loginStep;
    protected ProjectStep projectStep;
    protected DashboardStep dashboardStep;
    protected User userSuccessful;
    protected User userIncorrect;
    protected User userWithLongPassword;
    protected User userWithShortPassword;
    protected Project project;

    @BeforeMethod
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 15000;
        Configuration.fastSetValue = true;

        loginStep = new LoginStep();
        dashboardStep = new DashboardStep();
        projectStep = new ProjectStep();
        userSuccessful = User.builder()
                .name(ReadProperties.username())
                .password(ReadProperties.password())
                .build();

        userIncorrect = User.builder()
                .name("andrewmrz@gmail.com")
                .password("Qwerty_123456789")
                .build();

        userWithLongPassword = User.builder()
                .name(ReadProperties.username())
                .password(ReadProperties.longPassword())
                .build();

        userWithShortPassword = User.builder()
                .name(ReadProperties.username())
                .password(ReadProperties.shortPassword())
                .build();

        project = Project.builder()
                .name("TestProject")
                .announcement("My new test project")
                .build();

        open("");
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
