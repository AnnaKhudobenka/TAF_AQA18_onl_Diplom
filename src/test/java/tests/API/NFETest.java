package tests.API;

import baseEntities.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NFETest extends BaseApiTest {
    private int milestoneID;

    @Test(priority = 2)
    public void addMilestoneTest() {
        milestoneID = milestoneAdapter.add(pathForMilestone, projectID).getId();
    }

    @Test(dependsOnMethods = "addMilestoneTest")
    public void getOneMilestoneTest() {
        Assert.assertEquals(milestoneAdapter.getOne(milestoneID).getId(), milestoneID);
    }

    @Test(priority = 1)
    public void getAllMilestonesTest() {
        milestoneAdapter.add(pathForMilestone, projectID);
        Assert.assertEquals(milestoneAdapter.getAll(projectID).getSize(), 1);
    }

    @Test(dependsOnMethods = "addMilestoneTest")
    public void updateMilestoneTest() {
        Assert.assertTrue(milestoneAdapter
                .update(pathForUpdateMilestone, milestoneID).is_completed());
    }

    @Test
    public void getProjectTest() {
        Assert.assertEquals(projectAdapter.get(projectID).getId(), projectID);
    }

    @Test
    public void deleteMilestoneTest() {
        if (milestoneID > 0) {
            Assert.assertEquals(milestoneAdapter.delete(milestoneID).getStatusCode(),
                    HttpStatus.SC_OK);
        }
    }
}
