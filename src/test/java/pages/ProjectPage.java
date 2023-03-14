package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {
    private By testCasesSectionLocator = By.id("navigation-suites");
    private By addTestCaseButtonLocator = By.id("sidebar-cases-add");
    private By milestoneSectionLocator = By.id("navigation-milestones");
    public SelenideElement getTestCasesSection() {
        return $(testCasesSectionLocator).shouldBe(visible);
    }

    public SelenideElement getAddTestCaseButton() {
        return $(addTestCaseButtonLocator).shouldBe(visible);
    }
    public SelenideElement getMilestoneSection(){
        return $(milestoneSectionLocator).shouldBe(visible);
    }
}
