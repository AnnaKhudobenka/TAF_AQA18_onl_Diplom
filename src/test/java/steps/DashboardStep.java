package steps;

import baseEntities.BaseStep;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class DashboardStep extends BaseStep {
    @Step("Переход к добавлению проекта")
    public void goToProjectCreation(){
        dashboardPage.getAddProjectButton().click();
    }

    @Step("Переход в проект")
    public void goToProject(){
        dashboardPage.getProjectName().click();
    }

    @Step("Обновление главной станицы")
    public SelenideElement hoverToResetButton() {
        dashboardPage.getResetButton().hover();
        return dashboardPage.getTooltip();
    }
}
