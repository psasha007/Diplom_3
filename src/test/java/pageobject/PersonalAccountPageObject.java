package pageobject;

import constants.Constants;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalAccountPageObject extends BasePage{
    // Страница Входа - локатор кнопки Войти в аккаунт
    private By buttonEnterAccount = By.xpath(".//button[text()='Войти в аккаунт']");

    // Страница Входа - локатор поле ввода email
    private By inputEmailField = By.xpath(".//fieldset[1]//input");

    // Страница Входа - локатор поле ввода Пароля
    private By inputPasswordField = By.xpath(".//fieldset[2]//input");

    // Страница Входа - локатор кнопки Войти
    private By buttonEnter = By.xpath(".//button[text()='Войти']");

    // Страница Профиля - локатор кнопки Выход
    private By buttonExit = By.xpath(".//button[text()='Выход']");

    // Страница Профиля - локатор кнопки Личный Кабинет
    private By buttonPersonalArea = By.xpath(".//*[text()='Личный Кабинет']");

    // Страница Профиля - локатор текста Имя
    private By inputTypeName = By.xpath(".//*[text()='Имя']");

    // Страница Профиля - локатор текста Логин
    private By inputTypeLogin = By.xpath(".//*[text()='Логин']");

    // Страница Профиля - локатор текста Пароль
    private By inputTypePassword = By.xpath(".//*[text()='Пароль']");

    // Страница Входа - локатор текста Вход
    private By textEnter = By.xpath(".//*[text()='Вход']");

    // Страница Профиля - локатор текста Конструктор
    private By textConstructor = By.xpath(".//*[text()='Конструктор']");

    // Страница Конструктора - локатор кнопки Оформить заказ
    private By buttonCreateOrder = By.xpath(".//button[text()='Оформить заказ']");

    // Страница Профиля - локатор Stellar Burgers
    private By stellarBurgers = By.xpath("//a[.//*[@id='filter0_f']]");

    @Step("Проверка отображения текста Оформить заказ")
    public PersonalAccountPageObject checkTextCreateOrder(String expected){
        waitForElement(buttonCreateOrder, Constants.TIME_OUT_IN_SECONDS);
        WebElement actual = driver.findElement(buttonCreateOrder);
        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
        return this;
    }

    @Step("Нажатие на линкТекст Конструктор")
    public PersonalAccountPageObject clickStellarBurgers(){
        waitForElement(stellarBurgers, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(stellarBurgers).click();
        return this;
    }

    @Step("Нажатие на линкТекст Конструктор")
    public PersonalAccountPageObject clickTextConstructor(){
        waitForElement(textConstructor, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(textConstructor).click();
        return this;
    }

    @Step("Проверка отображается ли кнопка Вход")
    public PersonalAccountPageObject isDisplayedButtonEnter() {
        waitForElement(buttonEnter, Constants.TIME_OUT_IN_SECONDS);
        Assert.assertTrue(driver.findElement(buttonEnter).isDisplayed());
        return this;
    }

    @Step("Проверка отображается ли текст Вход")
    public PersonalAccountPageObject isDisplayedTextEnter() {
        waitForElement(textEnter, Constants.TIME_OUT_IN_SECONDS);
        Assert.assertTrue(driver.findElement(textEnter).isDisplayed());
        return this;
    }

    @Step("Проверка отображается ли поле Имя")
    public PersonalAccountPageObject isDisplayedFieldName() {
        waitForElement(inputTypeName, Constants.TIME_OUT_IN_SECONDS);
        Assert.assertTrue(driver.findElement(inputTypeName).isDisplayed());
        return this;
    }

    @Step("Проверка отображается ли поле Логин")
    public PersonalAccountPageObject isDisplayedFieldLogin() {
        waitForElement(inputTypeLogin, Constants.TIME_OUT_IN_SECONDS);
        Assert.assertTrue(driver.findElement(inputTypeLogin).isDisplayed());
        return this;
    }

    @Step("Проверка отображается ли поле Пароль")
    public PersonalAccountPageObject isDisplayedFieldPassword() {
        waitForElement(inputTypePassword, Constants.TIME_OUT_IN_SECONDS);
        Assert.assertTrue(driver.findElement(inputTypePassword).isDisplayed());
        return this;
    }

    @Step("Проверка текста Оформить заказ")
    public PersonalAccountPageObject checkTextName(String expected){
        waitForElement(inputTypeName, Constants.TIME_OUT_IN_SECONDS);
        WebElement actual = driver.findElement(inputTypeName);
        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getTagName());
        return this;
    }

    @Step("Нажатие на кнопку Войти")
    public PersonalAccountPageObject clickButtonEnter(){
        waitForElement(buttonEnter, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(buttonEnter).click();
        return this;
    }

    @Step("Нажатие на кнопку Выйти")
    public PersonalAccountPageObject clickButtonExit(){
        waitForElement(buttonExit, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(buttonExit).click();
        return this;
    }

    @Step("Ввод значения в поле Пароль")
    public PersonalAccountPageObject sendPasswordToField(String name){
        waitForElement(inputPasswordField, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(inputPasswordField).sendKeys(name);
        return this;
    }

    @Step("Ввод значения в поле email")
    public PersonalAccountPageObject sendEmailToField(String name){
        waitForElement(inputEmailField, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(inputEmailField).sendKeys(name);
        return this;
    }

    @Step("Нажатие на кнопку Войти в аккаунт")
    public PersonalAccountPageObject clickButtonEnterAccount(){
        waitForElement(buttonEnterAccount, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(buttonEnterAccount).click();
        return this;
    }

    @Step("Нажатие на кнопку Личный Кабинет")
    public PersonalAccountPageObject clickButtonPersonalArea (){
        waitForElement(buttonPersonalArea, Constants.TIME_OUT_IN_SECONDS);
        driver.findElement(buttonPersonalArea).click();
        return this;
    }

    // Конструктор
    public PersonalAccountPageObject(WebDriver driver) {
        super(driver);
    }
}
