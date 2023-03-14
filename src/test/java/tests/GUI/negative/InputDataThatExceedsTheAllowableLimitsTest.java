package tests.GUI.negative;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class InputDataThatExceedsTheAllowableLimitsTest extends BaseTest {
    @Test(description = "Тест на ввод данных превышающих допустимые ")
    public void InputDataThatExceedsTheAllowableLimitsTest(){
        loginStep.loginWithLongPassword(userWithLongPassword).shouldHave(text("Field Password is too long (128 characters at most)."));
    }
}
