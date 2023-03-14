package tests.GUI.negative;

import baseEntities.BaseTest;
import org.testng.annotations.Test;

public class FailedTest extends BaseTest {
    @Test
    public void loginTest(){
        loginStep.loginSuccessful(userIncorrect);
    }
}
