package adapters;

import models.Project;
import org.apache.http.HttpStatus;
import utils.Endpoints;


import java.io.File;

import static io.restassured.RestAssured.given;

public class ProjectAdapter {

    public Project add(File file) {
        return given()
                .body(file)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class);
    }

    public void delete(int projectID) {
        given()
                .pathParam("project_id", projectID)
                .when()
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public Project get(int projectID) {
        return given()
                .pathParam("project_id", projectID)
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().body()
                .extract()
                .as(Project.class);
    }
}
