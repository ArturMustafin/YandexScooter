package ru.scooter;

import org.junit.Test;
import ru.scooter.Page.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class oneTest extends BaseTest{
    private final static String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    @Test
    public void checkTest(){
        MainPage mainPage = new MainPage(BASE_URL);

    }

}
