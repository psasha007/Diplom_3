import constants.Constants;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.PersonalAccountPageObject;

import static constants.Constants.DEFAULT_EMAIL;
import static constants.Constants.DEFAULT_PASSWORD;

@DisplayName("Проверка - Перехода в личный кабинет по клику на «Личный кабинет»")
public class GoToPersonalAccountTest extends BaseTest{
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
    @DisplayName("Проверка - Успешная авторизация в личный кабинет - мы на странице Профиль")
    public void checkEnterAccountTest() {
        goToPersonalAccount
                .clickButtonEnterAccount()
                .sendEmailToField(DEFAULT_EMAIL)
                .sendPasswordToField(DEFAULT_PASSWORD)
                .clickButtonEnter()
                .clickButtonPersonalArea()
                .isDisplayedFieldName()
                .isDisplayedFieldLogin()
                .isDisplayedFieldPassword()
        ;
    }
}
