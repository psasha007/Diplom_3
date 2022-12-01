package pageobject;

import constants.Constants;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPageObject extends BasePage{
    // Страница Регистрация - локатор поле ввода имени
    private By inputNameField = By.xpath(".//fieldset[1]//input");

    // Страница Регистрация - локатор поле ввода email
    private By inputEmailField = By.xpath(".//fieldset[2]//input");

    // Страница Регистрация - локатор поле ввода Пароля
    private By inputPasswordField = By.xpath(".//fieldset[3]//input");

    // Страница Регистрация - локатор кнопки Зарегистрироваться."
    private By buttonRegistration = By.xpath(".//button[text()='Зарегистрироваться']");

    // Страница Регистрация - локатор текст сообщения Некорректный пароль
    private By textIncorrectPassword = By.xpath("//*[text() = 'Некорректный пароль']");

    // Страница Регистрация - локатор текст сообщения Такой пользователь уже существует
    private By textUserAlreadyExists = By.xpath("//*[text() = 'Такой пользователь уже существует']");

    // Страница Входа - Успешная регистрация  https://stellarburgers.nomoreparties.site/login
    private By textEnter = By.xpath("//*[text() = 'Вход']");


    // Конструктор
    public RegistrationPageObject(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод значения в поле Имя")
    public RegistrationPageObject sendNameToField(String name){
        waitForElement(inputNameField, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(inputNameField).sendKeys(name);
        return this;
    }

    @Step("Ввод значения в поле email")
    public RegistrationPageObject sendEmailToField(String name){
        waitForElement(inputEmailField, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(inputEmailField).sendKeys(name);
        return this;
    }

    @Step("Ввод значения в поле Пароль")
    public RegistrationPageObject sendPasswordToField(String name){
        waitForElement(inputPasswordField, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(inputPasswordField).sendKeys(name);
        return this;
    }

    @Step("Нажатие на кнопку Зарегистрироваться")
    public RegistrationPageObject clickButtonRegistration(){
        waitForElement(buttonRegistration, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(buttonRegistration).click();
        return this;
    }

    @Step("Проверка сообщения - Некорректный пароль")
    public RegistrationPageObject checkTextIncorrectPassword(String expected){
        waitForElement(textIncorrectPassword, Constants.TIME_OUT_IN_SECONDS);
        WebElement actual = driver.findElement(textIncorrectPassword);
        Assert.assertEquals("Ошибка, ожидаем текст 'Некорректный пароль'", expected, actual.getText());
        return this;
    }

    @Step("Проверка сообщения - Такой пользователь уже существует")
    public RegistrationPageObject checkTextUserAlreadyExists(String expected){
        waitForElement(textUserAlreadyExists, Constants.TIME_OUT_IN_SECONDS);
        WebElement actual = driver.findElement(textUserAlreadyExists);
        Assert.assertEquals("Ошибка, ожидаем текст 'Такой пользователь уже существует'", expected, actual.getText());
        return this;
    }

    @Step("Проверка текста Вход на странице")
    public RegistrationPageObject checkTextEnter(String expected){
        waitForElement(textEnter, Constants.TIME_OUT_IN_SECONDS);
        WebElement actual = driver.findElement(textEnter);
        Assert.assertEquals("Ошибка, ожидаем текст 'Вход'", expected, actual.getText());
        return this;
    }
}
