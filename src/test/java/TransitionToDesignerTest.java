import constants.Constants;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.PersonalAccountPageObject;

import static constants.Constants.DEFAULT_EMAIL;
import static constants.Constants.DEFAULT_PASSWORD;

@DisplayName("Проверка - перехода из личного кабинета в конструктор")
public class TransitionToDesignerTest extends BaseTest {
    PersonalAccountPageObject goToPersonalAccount;

    @Before
    public void startWebDriver() {
        goToPersonalAccount = new PersonalAccountPageObject(chrome(Constants.BASE_URL));
    }

    @After
    public void closeWebDriver(){
        driverQuit();
    }

    @Test
    @DisplayName("Проверка - перехода по клику на кнопку «Конструктор» из личного кабинета на страницу Конструктора")
    public void checkEnterConstructorTest() {
        goToPersonalAccount
                .clickButtonEnterAccount()
                .sendEmailToField(DEFAULT_EMAIL)
                .sendPasswordToField(DEFAULT_PASSWORD)
                .clickButtonEnter()
                .clickButtonPersonalArea()
                .clickTextConstructor()
                .checkTextCreateOrder("Оформить заказ")
        ;
    }

    @Test
    @DisplayName("Проверка - перехода по клику на логотип Stellar Burgers из личного кабинета на страницу Конструктора")
    public void checkEnterStellarBurgersTest() {
        goToPersonalAccount
                .clickButtonEnterAccount()
                .sendEmailToField(DEFAULT_EMAIL)
                .sendPasswordToField(DEFAULT_PASSWORD)
                .clickButtonEnter()
                .clickButtonPersonalArea()
                .clickStellarBurgers()
                .checkTextCreateOrder("Оформить заказ")
        ;
    }
}
