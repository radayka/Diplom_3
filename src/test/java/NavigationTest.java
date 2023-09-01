import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pom.*;

public class NavigationTest extends BaseTest {
    @Before
    public void registrationUser(){
        getUser().registrationUser(getUserRegistration());
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    @Description("Проверка перехода по клику на «Личный кабинет»")
    public void checkMoveToProfilePageFromMainPageRegisteredUser(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(profilePage.checkNameField());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    @Description("Проверка перехода из личного кабинета в конструктор по клику на «Конструктор»")
    public void checkMoveToConstructorFromProfileOnConstructorButton(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnConstructorButton();
        Assert.assertTrue(mainPage.checkConstructBurgerHeader());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    @Description("Проверка перехода из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void checkMoveToConstructorFromProfileOnStellarBurgersLogo(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnButtonPersonalAccount();
        mainPage.clickOnLogoStellarBurgers();
        Assert.assertTrue(mainPage.checkConstructBurgerHeader());
    }
    @Test
    @DisplayName("Работа перехода на вкладку «Булки»")
    @Description("Проверка перехода на вкладку «Булки» c других вкладок")
    public void checkMovingBetweenTabsIngredientsAndBuns(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnIngredientsTab();
        mainPage.clickOnBunsTab();
        Assert.assertEquals("Некорретная вкладка! Должен быть переход на вкладку Булки", "Булки", mainPage.getTextFromChosenElement());
    }

    @Test
    @DisplayName("Работа перехода на вкладку «Соусы»")
    @Description("Проверка перехода на вкладку «Соусы» c других вкладок")
    public void checkMovingBetweenChaptersIngredientsAndSauces() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnIngredientsTab();
        mainPage.clickOnSaucesTab();
        Assert.assertEquals("Некорретная вкладка! Должен быть переход на вкладку Соусы", "Соусы", mainPage.getTextFromChosenElement());
    }

    @Test
    @DisplayName("Работа перехода на вкладку «Начинки»")
    @Description("Проверка перехода на вкладку «Начинки» c других вкладок")
    public void checkMovingBetweenChaptersSaucesAndIngredients() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnSaucesTab();
        mainPage.clickOnIngredientsTab();
        Assert.assertEquals("Некорретная вкладка! Должен быть переход на вкладку Начинки", "Начинки", mainPage.getTextFromChosenElement());
    }
}