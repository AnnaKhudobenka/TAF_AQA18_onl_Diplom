package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private By usernameLocator = By.id("name");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.id("button_primary");
    private By passwordLengthErrorLocator = By.xpath("//*[text() = 'Field Password is too long (128 characters at most).']");
    private By wrongDataErrorLocator = By.xpath("//*[text() = 'Email/Login or Password is incorrect. Please try again.']");
    private By tooShortPasswordErrorLocator = By.xpath("//*[text() = 'Password is too short (5 characters required).']");



    public SelenideElement getUsernameInput() {
        return $(usernameLocator).shouldBe(visible);
    }
    public SelenideElement getPasswordInput() {
        return $(passwordLocator).shouldBe(visible);
    }
    public SelenideElement getLoginButton() {return $(loginButtonLocator).shouldBe(visible);}
    public SelenideElement getLongPasswordError() {return $(passwordLengthErrorLocator).shouldBe(visible);}
    public SelenideElement getWrongDataError() {return $(wrongDataErrorLocator).shouldBe(visible);}
    public SelenideElement getShortPasswordError(){return $(tooShortPasswordErrorLocator).shouldBe(visible);}
}
