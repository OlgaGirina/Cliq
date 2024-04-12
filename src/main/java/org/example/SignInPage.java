package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }
    private By login = By.xpath("//div/input[@name='login-form[login]']");
    private By password = By.xpath("//div//input[@name='login-form[password]']");
    private By submitButton = By.xpath("//button[@type='submit']");

public MainPage SignInSuccessful(){
    webDriver.findElement(login).sendKeys("olga");
    webDriver.findElement(password).sendKeys("Dimapovrez123");
    WebElement button = webDriver.findElement(submitButton);
    button.submit();
    return new MainPage(webDriver);
}
}