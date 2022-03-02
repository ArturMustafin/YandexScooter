package ru.scooter.Page;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.open;

/**
 * Главная страница сайта "Самокат"
 */
public class MainPage {
    public static HashMap<String, String> questions = new HashMap<>();

    //private final Selenide


    public MainPage(String url) {
        open(url);
    }

    public void clickButton(){

    }






    public void suiteQuestion() {
        questions.put("1", ".//div[1][@class='accordion__item']");
        questions.put("2", ".//div[2][@class='accordion__item']");
        questions.put("3", ".//div[3][@class='accordion__item']");
        questions.put("4", ".//div[4][@class='accordion__item']");
        questions.put("5", ".//div[5][@class='accordion__item']");
        questions.put("6", ".//div[6][@class='accordion__item']");
        questions.put("7", ".//div[7][@class='accordion__item']");
        questions.put("8", ".//div[8][@class='accordion__item']");
    }
}
