package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    public MainPage (WebDriver webDriver) {
        super(webDriver);
    }
    private By text = By.xpath("//a[text() = \"  CLIQ Admin\"]");
    public String getText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(text));
        return webDriver.findElement(text).getText();

    }
}
