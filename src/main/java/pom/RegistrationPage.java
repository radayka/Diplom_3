package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;

    private final By nameField = By.xpath(".//form/fieldset[1]/div/div/input");
    private final By emailField = By.xpath(".//form/fieldset[2]/div/div/input");
    private final By passwordField = By.xpath(".//form/fieldset[3]/div/div/input");
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By incorrectPassword = By.xpath(".//p[text()='Некорректный пароль']");
    private final By signInButton = By.xpath(".//a[text()='Войти']");

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Выбор поля и ввод имени")
    public void inputName(String name){
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
    }
    @Step("Выбор поля и ввод email")
    public void inputEmail(String name){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(name);
    }
    @Step("Выбор поля и ввод пароля")
    public void inputPassword(String name){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(name);
    }
    @Step("Клик по кнопке Зарегистрироваться")
    public void clickOnRegistrationButton(){
        driver.findElement(registrationButton).click();
    }
    @Step("Регистрация нового пользователя")
    public void registrationNewUser(String name, String email, String password){
        inputName(name);
        inputEmail(email);
        inputPassword(password);
        clickOnRegistrationButton();
    }
    @Step("Клик по кнопке Войти на странице регистрации")
    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }
    @Step("Получить текст ошибки Некорректный пароль")
    public boolean checkIncorrectPassword() {
        return driver.findElement(incorrectPassword).isDisplayed();
    }
}
