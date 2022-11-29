import constants.Constants;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.EntrancePageObject;

import static constants.Constants.DEFAULT_EMAIL;
import static constants.Constants.DEFAULT_PASSWORD;

@DisplayName("Проверка - Успешной авторизации")
public class EntranceTest extends BaseTest{
    EntrancePageObject entrance;

    @Before
    public void startWebDriver() {
        entrance = new EntrancePageObject(chrome(Constants.BASE_URL));
    }

    @After
    public void closeWebDriver(){
        driverQuit();
    }

    @Test
    @DisplayName("Проверка - входа по кнопке «Войти в аккаунт» на главной")
    public void checkEnterAccountTest() {
        entrance
                .clickButtonEnterAccount()
                .sendEmailToField(DEFAULT_EMAIL)
                .sendPasswordToField(DEFAULT_PASSWORD)
                .clickButtonEnter()
                .checkTextCreateOrder("Оформить заказ")
        ;
    }

    @Test
    @DisplayName("Проверка - входа через кнопку «Личный кабинет»")
    public void checkPersonalArea() {
        entrance
                .clickButtonPersonalArea()
                .sendEmailToField(DEFAULT_EMAIL)
                .sendPasswordToField(DEFAULT_PASSWORD)
                .clickButtonEnter()
                .checkTextCreateOrder("Оформить заказ")
        ;
    }

    @Test
    @DisplayName("Проверка - входа через кнопку в форме регистрации")
    public void checkRegistration() {
        entrance
                .clickButtonEnterAccount()
                .clickLinkTextRegistration()
                .clickLinkTextEnter()
                .sendEmailToField(DEFAULT_EMAIL)
                .sendPasswordToField(DEFAULT_PASSWORD)
                .clickButtonEnter()
                .checkTextCreateOrder("Оформить заказ")
        ;
    }

    @Test
    @DisplayName("Проверка - входа через кнопку в форме восстановления пароля")
    public void checkRestorePassword() {
        entrance
                .clickButtonPersonalArea()
                .clickLinkTextRestorePassword()
                .clickLinkTextEnter()
                .sendEmailToField(DEFAULT_EMAIL)
                .sendPasswordToField(DEFAULT_PASSWORD)
                .clickButtonEnter()
                .checkTextCreateOrder("Оформить заказ")
        ;
    }
}
