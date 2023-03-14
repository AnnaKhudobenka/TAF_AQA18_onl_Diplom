package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage{
    private By addProjectButtonLocator = By.id("sidebar-projects-add");
    private By projectNameLocator = By.xpath("//*[text() = 'TestProject']");
    private By administrationButtonLocator = By.id("navigation-admin");
    private By resetButtonLocator = By.id("clickToReset");
    private By tooltipLocator = By.id("tooltip");
    public SelenideElement getAddProjectButton(){
        return $(addProjectButtonLocator).shouldBe(visible);
    }

    public SelenideElement getProjectName(){
        return $(projectNameLocator).shouldBe(visible);
    }

    public SelenideElement getAdministrationButton(){
        return $(administrationButtonLocator).shouldBe(visible);
    }
    public SelenideElement getResetButton(){
        return $(resetButtonLocator).shouldBe(visible);
    }
    public SelenideElement getTooltip(){
        return $(tooltipLocator).shouldBe(visible);
    }
}
