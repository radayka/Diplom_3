package api;

import api.spec.RequestSpecifications;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseSteps extends RequestSpecifications{
    @Step("Авторизация пользователя")
    public Response loginUser(Credentials credentials){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(credentials)
                .when()
                .post(USER_LOGIN);
    }
    @Step("Регистрация пользователя")
    public void registrationUser(Registration registration){
        given()
                .header("Content-type", "application/json")
                .and()
                .body(registration)
                .when()
                .post(USER_REGISTRATION);
    }

    @Step("Удаление пользователя")
    public void deleteUser(String accessToken){
        given()
                .header("Authorization", accessToken)
                .header("Content-type", "application/json")
                .delete(USER_BASE_URL);
    }
    @Step("Логаут пользователя")
    public void logoutUser(String accessToken){
        given()
                .header("Authorization", accessToken)
                .header("Content-type", "application/json")
                .post(USER_LOGOUT);
    }
}