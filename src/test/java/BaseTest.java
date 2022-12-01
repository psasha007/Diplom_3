import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    // запуск WebDriver chrome
    public WebDriver chrome(String baseUrl){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);
        driver.get(baseUrl);
        return driver;
    }

    // запуск WebDriver yandex
    public WebDriver yandex(String baseUrl){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);
        driver.get(baseUrl);
        return driver;
    }

    public void driverQuit(){
        driver.quit();
    }
}
