package pageobject;

import constants.Constants;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SectionConstructorPageObject extends BasePage {

    // Страница Входа - локатор текста кнопки Булки
    private By buttonBun = By.xpath("//span[text()='Булки']");

    // Страница Входа - локатор текста кнопки Соусы
    private By buttonSauce = By.xpath("//span[text()='Соусы']");

    // Страница Входа - локатор текста кнопки Начинки
    private By buttonFilling = By.xpath("//span[text()='Начинки']");

    // Страница Входа - локатор кнопки ингредиентов
    private By buttonAny = By.cssSelector(".tab_tab_type_current__2BEPc");


    // Конструктор
    public SectionConstructorPageObject(WebDriver driver) {
        super(driver);
    }

    @Step("Нажатие на кнопку Булки")
    public SectionConstructorPageObject clickButtonBun(){
        waitForElement(buttonBun, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(buttonBun).click();
        return this;
    }

    @Step("Нажатие на кнопку Соусы")
    public SectionConstructorPageObject clickButtonSauce(){
        waitForElement(buttonSauce, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(buttonSauce).click();
        return this;
    }

    @Step("Нажатие на кнопку Начинки")
    public SectionConstructorPageObject clickButtonFilling(){
        waitForElement(buttonFilling, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(buttonFilling).click();
        return this;
    }

    @Step("Проверка отображения текста на закладке")
    public SectionConstructorPageObject checkTextCurrentButton(String expected){
        waitForElement(buttonAny, Constants.TIME_OUT_IN_SECONDS);
        WebElement actual = driver.findElement(buttonAny);
        Assert.assertEquals("Ошибка, ожидаем текст " + expected, expected, actual.getText());
        return this;
    }
}
