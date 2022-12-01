import constants.Constants;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.PersonalAccountPageObject;

import static constants.Constants.DEFAULT_EMAIL;
import static constants.Constants.DEFAULT_PASSWORD;

@DisplayName("Проверка - Выхода из аккаунта")
public class LogoutTest extends BaseTest{
    PersonalAccountPageObject goToPersonalAccount;

    @Before
    public void startWebDriver() {
        goToPersonalAccount = new PersonalAccountPageObject(chrome(Constants.BASE_URL));
    }

    @After
    public void closeWebDriver() {
        driverQuit();
    }

    @Test
    @DisplayName("Проверка - Выхода по кнопке «Выйти» в личном кабинете")
    public void checkLogoutTest() {
        goToPersonalAccount
                .clickButtonEnterAccount()
                .sendEmailToField(DEFAULT_EMAIL)
                .sendPasswordToField(DEFAULT_PASSWORD)
                .clickButtonEnter()
                .clickButtonPersonalArea()
                .clickButtonExit()
                .isDisplayedTextEnter()
                .isDisplayedButtonEnter()
        ;
    }
}
