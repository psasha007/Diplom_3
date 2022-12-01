package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    //
    protected WebDriver driver;
    //
    protected JavascriptExecutor js;
    // Значение для локатора прокрутки
    protected String locatorScroll = "arguments[0].scrollIntoView();";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание нужного элемента в секундах")
    public WebElement waitForElement(By locator, long l) {
        return new WebDriverWait(driver, Duration.ofSeconds(l))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
