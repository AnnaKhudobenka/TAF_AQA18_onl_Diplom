package tests.GUI.positive;

import baseEntities.BaseTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class CreateProjectTest extends BaseTest {
    @Test(description = "Тест на создание сущности (проекта)")
    public void createProjectTest(){
        loginStep.loginSuccessful(userSuccessful);
        dashboardStep.goToProjectCreation();
        projectStep.createProject(project).shouldHave(text("Successfully added the new project."));
    }
}
