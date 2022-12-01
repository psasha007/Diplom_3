package pageobject;

import constants.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class EntrancePageObject extends BasePage{
    // Страница Входа - локатор поле ввода email
    private By inputEmailField = By.xpath(".//fieldset[1]//input");

    // Страница Входа - локатор поле ввода Пароля
    private By inputPasswordField = By.xpath(".//fieldset[2]//input");

    // Страница Входа - локатор кнопки Войти после ввода учетных данных
    private By buttonEnter = By.xpath(".//button[text()='Войти']");

    // Страница Входа - локатор кнопки Войти в аккаунт
    private By buttonEnterAccount = By.xpath(".//button[text()='Войти в аккаунт']");

    // Страница Входа - кнопка Оформить заказ
    private By buttonCreateOrder = By.xpath(".//button[text()='Оформить заказ']");

    // Страница Входа - локатор кнопки Личный Кабинет
    private By buttonPersonalArea = By.xpath(".//*[text()='Личный Кабинет']");

    // Страница Входа - локатор linkText = "Войти"
    private By linkTextEnter = By.linkText("Войти");

    // Страница Регистрация - локатор linkText "Зарегистрироваться"
    private By linkTextRegistration = By.linkText("Зарегистрироваться");

    // Страница Восстановление пароля - локатор linkText "Восстановить пароль"
    private By linkTextRestorePassword = By.linkText("Восстановить пароль");

    // Конструктор
    public EntrancePageObject(WebDriver driver) {
        super(driver);
    }

    @Step("Нажатие на кнопку Войти в аккаунт")
    public EntrancePageObject clickButtonEnterAccount(){
        waitForElement(buttonEnterAccount, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(buttonEnterAccount).click();
        return this;
    }

    @Step("Нажатие на кнопку Личный Кабинет")
    public EntrancePageObject clickButtonPersonalArea (){
        waitForElement(buttonPersonalArea, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(buttonPersonalArea).click();
        return this;
    }

    @Step("Нажатие на линк Войти")
    public EntrancePageObject clickLinkTextEnter (){
        waitForElement(linkTextEnter, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(linkTextEnter).click();
        return this;
    }

    @Step("Нажатие на линк Зарегистрироваться")
    public EntrancePageObject clickLinkTextRegistration (){
        waitForElement(linkTextRegistration, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(linkTextRegistration).click();
        return this;
    }

    @Step("Нажатие на линк Восстановить пароль")
    public EntrancePageObject clickLinkTextRestorePassword (){
        waitForElement(linkTextRestorePassword, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(linkTextRestorePassword).click();
        return this;
    }

    @Step("Ввод значения в поле email")
    public EntrancePageObject sendEmailToField(String name){
        waitForElement(inputEmailField, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(inputEmailField).sendKeys(name);
        return this;
    }

    @Step("Ввод значения в поле Пароль")
    public EntrancePageObject sendPasswordToField(String name){
        waitForElement(inputPasswordField, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(inputPasswordField).sendKeys(name);
        return this;
    }

    @Step("Ввод значения в поле Пароль")
    public EntrancePageObject clickButtonEnter(){
        waitForElement(buttonEnter, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(buttonEnter).click();
        return this;
    }

    @Step("Проверка отображения текста Оформить заказ")
    public EntrancePageObject checkTextCreateOrder(String expected){
        waitForElement(buttonCreateOrder, Constants.TIME_OUT_IN_SECONDS);
        WebElement actual = driver.findElement(buttonCreateOrder);
        Assert.assertEquals("Ошибка, ожидаем текст 'Оформить заказ'", expected, actual.getText());
        return this;
    }
}
