package ru.scooter;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;

public abstract class BaseTest {

    @Before
    public void setUp() {
        // почему-то не работает мб верстка не правильно сделана
        Cookie cookie = new Cookie("Cartoshka","true");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);

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
