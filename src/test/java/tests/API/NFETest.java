package tests.API;

import baseEntities.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NFETest extends BaseApiTest {
    private int milestoneID;

    @Test(priority = 2, description = "POST запрос на добавление майлстоуна")
    public void addMilestoneTest() {
        milestoneID = milestoneAdapter.add(pathForMilestone, projectID).getId();
    }

    @Test(dependsOnMethods = "addMilestoneTest",
            description = "GET запрос на получение одного майлстоуна")
    public void getOneMilestoneTest() {
        Assert.assertEquals(milestoneAdapter.getOne(milestoneID).getId(), milestoneID);
    }

    @Test(priority = 1,
            description = "GET запрос на получение пакета майлстоунов")
    public void getAllMilestonesTest() {
        milestoneAdapter.add(pathForMilestone, projectID);
        Assert.assertEquals(milestoneAdapter.getAll(projectID).getSize(), 1);
    }

    @Test(dependsOnMethods = "addMilestoneTest",
            description = "POST запрос на обновление майлстоуна")
    public void updateMilestoneTest() {
        Assert.assertTrue(milestoneAdapter
                .update(pathForUpdateMilestone, milestoneID).is_completed());
    }

    @Test(description = "GET запрос на получение проекта")
    public void getProjectTest() {
        Assert.assertEquals(projectAdapter.get(projectID).getId(), projectID);
    }

    @Test(description = "POST запрос на удаление майлстоуна")
    public void deleteMilestoneTest() {
        if (milestoneID > 0) {
            Assert.assertEquals(milestoneAdapter.delete(milestoneID).getStatusCode(),
                    HttpStatus.SC_OK);
        }
    }
}
