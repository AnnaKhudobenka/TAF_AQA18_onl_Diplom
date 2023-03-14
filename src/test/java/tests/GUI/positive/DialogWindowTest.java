package tests.GUI.positive;

import baseEntities.BaseTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class DialogWindowTest extends BaseTest {
    @Test(description = "Тест на отображение диалогового окна")
    public void dialogWindowTest(){
        loginStep.loginSuccessful(userSuccessful);
        dashboardStep.goToProjectCreation();
        projectStep.createProject(project);
        projectStep.goBackToDashboard();
        dashboardStep.goToProject();
        projectStep.goToTestCases();
        projectStep.addTable().shouldHave(text("|||:Header 1|:Header 2|:Header 3|:Header 4"));
    }
}
