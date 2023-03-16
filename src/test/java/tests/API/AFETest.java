package tests.API;

import baseEntities.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AFETest extends BaseApiTest {

    @Test(description = "POST запрос на ввод данных, превышающим допустимые")
    public void addMilestoneWithLongNameTest() {
        Assert.assertEquals(milestoneAdapter.add(pathForIncorrectMilestone, projectID).getError(),
                "Field :name is too long (250 characters at most).");
    }

    @Test(description = "GET запрос на получение несуществующего майлстоуна")
    public void getOneNotValidIDMilestoneTest() {
        Assert.assertEquals(milestoneAdapter.getOne(0).getError(),
                "Field :milestone_id is not a valid milestone.");
    }

    @Test(description = "GET запрос на получение несуществующего пакета майлстоунов")
    public void getAllNotValidIDMilestonesTest() {
        Assert.assertEquals(milestoneAdapter.getAll(0).getError(),
                "Field :project_id is not a valid or accessible project.");
    }

    @Test(description = "POST запрос обновление несуществующего майлстоуна")
    public void updateMilestoneWithNotValidIDTest() {
        Assert.assertEquals(milestoneAdapter
                .update(pathForUpdateMilestone, 0).getError(),
                "Field :milestone_id is not a valid milestone.");
    }

    @Test(description = "GET запрос на получение несуществующего проекта")
    public void getProjectWithNotValidIDTest() {
        Assert.assertEquals(projectAdapter.get(0).getError(),
                "Field :project_id is not a valid or accessible project.");
    }

    @Test(description = "POST запрос на удаление несуществующего майлстоуна")
    public void deleteMilestoneWithNotValidIDTest() {
        Assert.assertEquals(milestoneAdapter.delete(0).getStatusCode(),
                HttpStatus.SC_BAD_REQUEST);
    }
}
