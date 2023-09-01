package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage{
    private final WebDriver driver;
    private final By clickOnRememberPasswordLink = By.xpath(".//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }
    @Step("Вход по кнопке Войти в разделе восстановления пароля")
    public void clickOnRememberPasswordLink(){
        driver.findElement(clickOnRememberPasswordLink).click();
    }
}
