import constants.Constants;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.RegistrationPageObject;

import static constants.Constants.DEFAULT_PASSWORD;

@DisplayName("Проверка - Успешной регистрации")
public class RegistrationTrueTest extends BaseTest{
    RegistrationPageObject registration;

    @Before
    public void startWebDriver() {
        registration = new RegistrationPageObject(chrome(Constants.REGISTRATIONS_URL));
    }

    @After
    public void closeWebDriver() {
        driverQuit();
    }

    @Test
    @DisplayName("Проверка - Успешная регистрация нового пользователя")
    public void sendNameTest() {
        String name = RandomStringUtils.randomAlphanumeric(16);
        String email = RandomStringUtils.randomAlphanumeric(16) + "@yandex.ru";
        registration
                .sendNameToField(name)
                .sendEmailToField(email)
                .sendPasswordToField(DEFAULT_PASSWORD)
                .clickButtonRegistration()
                .checkTextEnter("Вход");
    }
}
