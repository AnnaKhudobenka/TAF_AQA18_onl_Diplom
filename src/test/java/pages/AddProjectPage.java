package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AddProjectPage {
    private By projectNameInputLocator = By.id("name");
    private By projectAnnouncementInputLocator = By.id("announcement");
    private By projectSingleSuiteLocator = By.id("suite_mode_single");
    private By showAnnouncementCheckboxLocator = By.id("show_announcement");
    private By addProjectButtonLocator = By.id("accept");

    public SelenideElement getProjectNameInput(){
        return $(projectNameInputLocator).shouldBe(visible);
    }
    public SelenideElement getProjectAnnouncementInput(){
        return $(projectAnnouncementInputLocator).shouldBe(visible);
    }
    public SelenideElement getSingleSuiteButton(){
        return $(projectSingleSuiteLocator).shouldBe(visible);
    }
    public SelenideElement getShowAnnouncementCheckbox(){
        return $(showAnnouncementCheckboxLocator).shouldBe(visible);
    }
    public SelenideElement getAddProjectButton(){
        return $(addProjectButtonLocator).shouldBe(visible);
    }
}
