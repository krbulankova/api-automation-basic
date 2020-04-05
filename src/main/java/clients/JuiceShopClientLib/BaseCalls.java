package clients.JuiceShopClientLib;

import domain.UserLogInResponse;
import helpers.TestCaseContext;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import payload.Payload;

public class BaseCalls {
  // Variables
  public static final String BASE_PAGE = "http://localhost:3000/";
  // Methods
  public ValidatableResponse post(String link, Payload payload){
    return  (ValidatableResponse) RestAssured.
            given().
            log().ifValidationFails().
            header("Authorization", "Bearer " + getToken()).
            contentType(ContentType.JSON).
            body(payload).
            when().
            post(BASE_PAGE + link).
            then().
            log().ifValidationFails();
  }
  public ValidatableResponse get(String link){
    return  (ValidatableResponse) RestAssured.
            given().
            log().ifValidationFails().
            header("Authorization", "Bearer " + getToken()).
            contentType(ContentType.JSON).
            body("{}").
            when().
            get(BASE_PAGE + link).
            then().
            log().ifValidationFails();
  }
  private String getToken(){
    UserLogInResponse loggedInUser = (UserLogInResponse) TestCaseContext.getLedger().get("loggedInUser");
    return ((loggedInUser == null) ? "" : loggedInUser.getToken());
  }
}
