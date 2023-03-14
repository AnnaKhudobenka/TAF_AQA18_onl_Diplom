package baseEntities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.*;

public class BaseStep {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected AddProjectPage addProjectPage;
    protected ProjectOverviewPage projectOverviewPage;
    protected ProjectPage projectPage;
    protected TestCasesPage testCasesPage;
    protected Logger logger;

    public BaseStep() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        addProjectPage = new AddProjectPage();
        projectOverviewPage = new ProjectOverviewPage();
        projectPage = new ProjectPage();
        testCasesPage = new TestCasesPage();
        logger = LogManager.getLogger();
    }
}
