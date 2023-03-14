package tests.GUI.positive;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class DeleteProjectTest extends BaseTest {
    @Test(description = "Тест на удаление сущности (проекта)")
    public void deleteProjectTest(){
        loginStep.loginSuccessful(userSuccessful);
        dashboardStep.goToProjectCreation();
        projectStep.createProject(project);
        projectStep.deleteProject().shouldHave(text("Successfully deleted the project."));
    }
}
