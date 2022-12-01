import constants.Constants;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.RegistrationPageObject;
import org.apache.commons.lang3.RandomStringUtils;

@DisplayName("Проверка - Регистрации на ошибку некорректного пароля, Минимальный пароль — шесть символов")
@RunWith(value = Parameterized.class)
public class RegistrationIncorrectPasswordParameterizedTest extends BaseTest{
    RegistrationPageObject registration;

    String password;

    public RegistrationIncorrectPasswordParameterizedTest(String password) {
        this.password = password;
    }

    @Parameterized.Parameters
    public static Object[] getSumData()
    {
        return new Object[][]
                {// тестовые данные
                        {"1"},
                        {"123"},
                        {"12345"}
                };
    }

    @Before
    public void startWebDriver() {
        registration = new RegistrationPageObject(chrome(Constants.REGISTRATIONS_URL));
    }

    @After
    public void closeWebDriver() {
       driverQuit();
    }

    @Test
    @DisplayName("Проверка - на сообщения 'Некорректный пароль', если пароль менее шести символов")
    public void sendNameTest() {
        registration
                .sendNameToField(RandomStringUtils.randomAlphanumeric(16))
                .sendEmailToField(RandomStringUtils.randomAlphanumeric(16) + "@yandex.ru")
                .sendPasswordToField(password)
                .clickButtonRegistration()
                .checkTextIncorrectPassword("Некорректный пароль");
    }
}
