package tests.GUI.positive;

import baseEntities.BaseTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class CheckInputFieldForBoundaryValuesTest extends BaseTest {
    @Test(description = "Тест на граничные значения")
    public void checkInputFieldForBoundaryValuesTest(){
        loginStep.loginWithShortPassword(userWithShortPassword).shouldHave(text("Password is too short (5 characters required)."));
        loginStep.clearPasswordField();
        loginStep.loginWithLongPassword(userWithLongPassword).shouldHave(text("Field Password is too long (128 characters at most)."));
        loginStep.clearPasswordField();
        loginStep.loginSuccessful(userSuccessful);
        //проверка что открылся дашборд
    }
}
