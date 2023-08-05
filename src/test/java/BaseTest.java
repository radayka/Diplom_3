import api.spec.RequestSpecifications;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import api.Credentials;
import api.Registration;
import api.BaseSteps;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static enviroment.SetupUp.browserDriverSetUp;

public class BaseTest {
    private final String email = "Test20Potok@mail.com";
    private final String password = "123456";
    private final String name = "Artem_93";
    private final String incorrectPassword = "12345";
    private WebDriver driver;
    private final BaseSteps baseSteps = new BaseSteps();
    private final Registration registration = new Registration(email, password, name);
    private final Credentials credentials = new Credentials(email, password);
    private final Credentials incorrectPasswordCredentials = new Credentials(email, incorrectPassword);

    public void setDriver() {
        driver = browserDriverSetUp();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(RequestSpecifications.MAIN_PAGE);
        driver.manage().window();
    }
    @Before
    public void setUp() {
        RestAssured.baseURI = RequestSpecifications.MAIN_PAGE;
        setDriver();
    }
    public WebDriver getDriver(){
        return driver;
    }
    public BaseSteps getUser(){
        return baseSteps;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getName(){
        return name;
    }
    public Credentials getUserLogin(){
        return credentials;
    }
    public Registration getUserRegistration(){
        return registration;
    }
    public String getIncorrectPassword(){
        return incorrectPassword;
    }
    public Credentials getLoginIncorrectUser(){
        return incorrectPasswordCredentials;
    }
    @After
    public void cleanUp(){
        Response response = getUser().loginUser(getUserLogin());
        if (response.jsonPath().get("success").equals(true)) {
            getUser().logoutUser(response.jsonPath().get("accessToken"));
            getUser().deleteUser(response.jsonPath().get("accessToken"));
        }
        response = getUser().loginUser(getLoginIncorrectUser());
        if (response.jsonPath().get("success").equals(true)) {
            getUser().logoutUser(response.jsonPath().get("accessToken"));
            getUser().deleteUser(response.jsonPath().get("accessToken"));
        }
        driver.quit();
    }
}
