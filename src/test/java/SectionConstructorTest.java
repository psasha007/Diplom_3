import constants.Constants;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.SectionConstructorPageObject;

@DisplayName("Проверка - что работают переходы к разделам «Конструктора»")
public class SectionConstructorTest extends BaseTest{
     SectionConstructorPageObject goToConstructor;

    @Before
    public void startWebDriver() {
        goToConstructor = new SectionConstructorPageObject(chrome(Constants.BASE_URL));
    }

    @After
    public void closeWebDriver() {
        driverQuit();
    }

    @Test
    @DisplayName("Проверка - перехода к разделу Булки")
    public void checkGoToBunTest() {
        goToConstructor
                .clickButtonSauce()
                .clickButtonBun()
                .checkTextCurrentButton("Булки")
        ;
    }

    @Test
    @DisplayName("Проверка - перехода к разделу Соусы")
    public void checkGoToSauceTest() {
        goToConstructor
                .clickButtonSauce()
                .checkTextCurrentButton("Соусы")
        ;
    }

    @Test
    @DisplayName("Проверка - перехода к разделу Начинки")
    public void checkGoToFillingTest() {
        goToConstructor
                .clickButtonFilling()
                .checkTextCurrentButton("Начинки")
        ;
    }
}
