package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.UserDTO;
import utils.RestAssuredUtils;

import static utils.JsonUtils.fromJson;

public class UserSteps {
    //    public UserDTO[] getUsers() {
//        Response response = RestAssuredUtils.createGet("/users");
//        return fromJsonToArray(response.getBody().toString(), UserDTO[].class);
//    }

    @Step("Получить пользователя по ID:{id}")
    public UserDTO getUserById(int id) {
        Response response = RestAssuredUtils.createGet("user-validation.json", 200, "/users/" + id);
        return fromJson(response.getBody().asString(), UserDTO.class);
    }
}
