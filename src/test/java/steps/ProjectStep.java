package steps;

import baseEntities.BaseStep;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.netty.channel.SelectStrategy;
import io.qameta.allure.Step;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import tests.GUI.positive.FileUploadTest;

import java.io.File;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.*;

public class ProjectStep extends BaseStep {
    @Step("Добавление проекта")
    public SelenideElement createProject(Project project){
        logger.info("In step createProject Project object is using, wich contains fields: " + project);
        addProjectPage.getProjectNameInput().setValue(project.getName());
        addProjectPage.getProjectAnnouncementInput().setValue(project.getAnnouncement());
        addProjectPage.getShowAnnouncementCheckbox().click();
        addProjectPage.getSingleSuiteButton().click();
        addProjectPage.getAddProjectButton().click();
       return projectOverviewPage.getSuccessfulMessage();
    }
    @Step("Переход на главную страницу")
    public void goBackToDashboard(){
        projectOverviewPage.getDashboardButton().click();
        dashboardPage.getAddProjectButton();
    }

    @Step("Переход в секцию тест-кейсов")
    public void goToTestCases(){
        projectPage.getTestCasesSection().click();
    }
    @Step("Загрузка файла")
    public String uploadFile() {
        String pathToFile = FileUploadTest.class.getClassLoader().getResource("testcaselogo.png").getPath().substring(1);
        projectPage.getAddTestCaseButton().click();
        testCasesPage.getOpenLibraryButton().uploadFile(new File(pathToFile));
        testCasesPage.getTitleInput().setValue("Verify that file upload works correctly");
        testCasesPage.getAttachmentName();
        testCasesPage.getAddTestCaseButton().submit();
        byte[] bytes = testCasesPage.getAttachmentName().getAttribute("title").getBytes();
        String string = new String(bytes);
        System.out.println(string);
        return string;
    }
    @Step("Добавление таблицы")
    public SelenideElement addTable(){
        projectPage.getAddTestCaseButton().click();
        testCasesPage.getTitleInput().setValue("Verify that file upload works correctly");
        testCasesPage.getAddTableButton().click();
        testCasesPage.getSubmitTableButton().click();
        return testCasesPage.getPreconditionInput();
    }

    @Step("Удаление проекта")
    public SelenideElement deleteProject(){
        projectOverviewPage.getDeleteButton().click();
        projectOverviewPage.getCheckbox().click();
        projectOverviewPage.getOKButton().click();
        return projectOverviewPage.getSuccessfulMessage();
    }
}
