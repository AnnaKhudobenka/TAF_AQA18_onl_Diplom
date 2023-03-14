package baseEntities;

import adapters.MilestoneAdapter;
import adapters.ProjectAdapter;
import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Project;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.*;

import java.io.File;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected ProjectAdapter projectAdapter;
    protected MilestoneAdapter milestoneAdapter;
    protected File pathForProject;
    protected File pathForMilestone;
    protected File pathForIncorrectMilestone;
    protected File pathForUpdateMilestone;
    protected Project projectApi;
    protected int projectID;

    @BeforeClass
    public void setupApi() {
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .auth().preemptive()
                .basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

        projectAdapter = new ProjectAdapter();
        milestoneAdapter = new MilestoneAdapter();

        pathForProject = new File("src/test/resources/filesForRestApiTest/project.json");
        pathForMilestone = new File("src/test/resources/filesForRestApiTest/milestone.json");
        pathForIncorrectMilestone = new File("src/test/resources/filesForRestApiTest/incorrectMilestone.json");
        pathForUpdateMilestone = new File("src/test/resources/filesForRestApiTest/updateMilestone.json");

        projectApi = projectAdapter.add(pathForProject);
        projectID = projectApi.getId();
    }

    @AfterClass
    public void tearDown() {
        if (projectID > 0) {
            projectAdapter.delete(projectID);
        }
    }
}
