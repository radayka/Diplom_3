import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import pom.*;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationTest extends BaseTest{
    @Test
    @DisplayName("Регистрация нового пользователя")
    @Description("Проверка регистрации нового пользователя")
    public void registrationNewUserTest(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegistrationLink();
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.registrationNewUser(getName(), getEmail(), getPassword());
        Assert.assertTrue(loginPage.checkEnterHeader());
    }
    @Test
    @DisplayName("Получение ошибки при вводе некорректного пароля")
    @Description("Ошибка для некорректного пароля при создании пароля менее 6 символов")
    public void registrationUserWithIncorrectPasswordTest(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegistrationLink();
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.registrationNewUser(getName(), getEmail(), getIncorrectPassword());
        Assert.assertTrue(registrationPage.checkIncorrectPassword());
    }
}
