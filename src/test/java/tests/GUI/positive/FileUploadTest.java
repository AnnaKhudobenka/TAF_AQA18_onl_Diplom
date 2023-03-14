package tests.GUI.positive;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.ProjectStep;

public class FileUploadTest extends BaseTest {
    @Test(description = "Тест на загрузку файла")
    public void uploadFileTest(){
        loginStep.loginSuccessful(userSuccessful);
        dashboardStep.goToProjectCreation();
        projectStep.createProject(project);
        projectStep.goBackToDashboard();
        dashboardStep.goToProject();
        projectStep.goToTestCases();
        Assert.assertTrue(projectStep.uploadFile().startsWith("testcaselogo.png"));
    }
}
