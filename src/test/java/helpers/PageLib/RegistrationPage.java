package helpers.PageLib;

import domain.User;
import helpers.TestCaseContext;
import io.cucumber.datatable.DataTable;
import io.restassured.response.ValidatableResponse;
import payload.SecurityQuestionPayload;
import payload.UserRegistrationPayload;
import java.util.Map;

import static helpers.Logger.info;
import static helpers.TestCaseContext.JUICE_SHOP_CLIENT;

public class RegistrationPage extends BasePage {
  // Methods
  @Override
  public void doAction(String action, DataTable dataTable) {
    switch (capitalizeSecond(action)){
      case "createUser": createUser(dataTable); break;
      default          : super.doAction(action, dataTable);
    }
  }
  public void createUser(DataTable dataTable){
    Map<String, String> map = dataTable.transpose().asMaps().get(0);
    info("Creating user with the following data:\n" + map);
    String email = map.get("Email").toString();
    String password = map.get("Password").toString();
    String securityAnswer = map.get("Security answer").toString();
    String securityQuestion = map.get("Security question").toString();
    SecurityQuestionPayload securityQuestionPayload = new SecurityQuestionPayload(securityQuestion);
    UserRegistrationPayload userRegistrationPayload =
            new UserRegistrationPayload(email, password, securityQuestionPayload, securityAnswer);
    ValidatableResponse response =
            JUICE_SHOP_CLIENT.getRegistrationCalls().createUser(userRegistrationPayload);
    response.statusCode(201);
    User user = response.extract().body().as(User.class);
    TestCaseContext.getLedger().put("user", user);
  }
}
