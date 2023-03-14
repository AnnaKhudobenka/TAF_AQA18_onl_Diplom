package tests.GUI.positive;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class TooltipTest extends BaseTest {
    @Test(description = "Тест на проверку всплывающего сообщения")
    public void tooltipTest(){
        loginStep.loginSuccessful(userSuccessful);
        dashboardStep.hoverToResetButton().shouldHave(text("Reset"));
    }
}
