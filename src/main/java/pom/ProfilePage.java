package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private final WebDriver driver;

    private final By nameField = By.xpath(".//input[@value='Artem_93']");
    private final By exitButton = By.xpath(".//button[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Получить заголовок Имя")
    public boolean checkNameField() {
        return driver.findElement(nameField).isDisplayed();
    }

    @Step("Выход из профиля")
    public void clickOnExitButton() {
        driver.findElement(exitButton).click();
    }
}
