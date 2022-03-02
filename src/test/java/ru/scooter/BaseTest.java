package ru.scooter;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        // отображение браузера
        Configuration.headless = true;
    }

    @Before
    public void  init() {
        setUp();
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
