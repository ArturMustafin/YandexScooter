package ru.scooter;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

public abstract class BaseTest {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        // size
        Configuration.startMaximized = true;
        // отображение браузера
        Configuration.headless = true;
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
