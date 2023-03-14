package tests.GUI.negative;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class InputIncorrectDataTest extends BaseTest {
    @Test(description = "Тест на использование некорректных данных")
    public void InputIncorrectDataTest() {
        loginStep.loginIncorrect(userIncorrect).shouldHave(text("Email/Login or Password is incorrect. Please try again."));
    }
}
