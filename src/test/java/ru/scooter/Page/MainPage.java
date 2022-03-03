package ru.scooter.Page;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Главная страница сайта "Самокат"
 */
public class MainPage extends BasePage {

//
    public static final Map<Integer, String> answerToQuestion = Map.of(
            1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    );

    public MainPage(String url) {
        open(url);
    }

    public void clickQuestion(int numberQuestion) {
        // close Cookie, в некоторых кейсах мешают куки.
        // Не нравится решение закрывать куки сдесь подскажите как лучше сделатью.
        if(numberQuestion == 1){
            $(byId("rcc-confirm-button")).click();
        }

        clickButton(".//div[" + numberQuestion + "][@class='accordion__item']");
    }

    public String getTextAnswer(int numberQuestion) {
        return $(byXpath(".//div[@id='accordion__panel-" + (numberQuestion - 1) + "']/p")).getText();
    }
}
