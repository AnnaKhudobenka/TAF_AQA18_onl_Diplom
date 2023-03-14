package adapters;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Milestone;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class MilestoneAdapter {

    public Milestone add(File file, int projectID) {
        return given()
                .pathParam("project_id", projectID)
                .body(file)
                .when()
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .log().body()
                .extract()
                .as(Milestone.class);
    }

    public Response delete(int milestoneID) {
        return given()
                .pathParam("milestone_id", milestoneID)
                .when()
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .extract()
                .response();
    }

    public Milestone getOne(int milestoneID) {
        return given()
                .pathParam("milestone_id", milestoneID)
                .when()
                .get(Endpoints.GET_MILESTONE)
                .then()
                .log().body()
                .extract()
                .as(Milestone.class);
    }
    public Milestone getAll(int projectID) {
        return given()
                .pathParam("project_id", projectID)
                .when()
                .get(Endpoints.GET_MILESTONES)
                .then()
                .log().body()
                .extract()
                .as(Milestone.class);
    }

    public Milestone update(File file, int milestoneID) {
        return given()
                .pathParam("milestone_id", milestoneID)
                .body(file)
                .when()
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .extract()
                .as(Milestone.class, ObjectMapperType.GSON);
    }
}
