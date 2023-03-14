package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TestCasesPage {
    private By openLibraryButtonLocator = By.cssSelector("input[type='file']");
    private By attachmentNameLocator = By.xpath("//*[starts-with(@title, 'testcaselogo')]");
    private By titleInputLocator = By.id("title");
    private By addTestCaseButtonLocator = By.id("accept");
    private By addTableButtonLocator = By.className("icon-markdown-table");
    private By submitTableButtonLocator = By.id("addTableSubmit");
    private By preconditionInputLocator = By.id("custom_preconds_display");

    public SelenideElement getOpenLibraryButton(){
        return $(openLibraryButtonLocator).should(exist);
    }
    public SelenideElement getAttachmentName(){
        return $(attachmentNameLocator).shouldBe(visible);
    }
    public SelenideElement getTitleInput(){
        return $(titleInputLocator).shouldBe(visible);
    }
    public SelenideElement getAddTestCaseButton(){
        return $(addTestCaseButtonLocator).shouldBe(visible);
    }
    public SelenideElement getAddTableButton(){
        return $(addTableButtonLocator).shouldBe(visible);
    }
    public SelenideElement getSubmitTableButton(){
        return $(submitTableButtonLocator).shouldBe(visible);
    }
    public SelenideElement getPreconditionInput(){
        return $(preconditionInputLocator).shouldBe(visible);
    }
}
