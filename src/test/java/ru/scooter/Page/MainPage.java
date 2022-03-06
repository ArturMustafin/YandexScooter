package ru.scooter.Page;

import org.openqa.selenium.By;

import java.util.Map;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

/**
 * Главная страница сайта "Самокат"
 */
public class MainPage extends BasePage {
    private final By cookieButton = By.id("rcc-confirm-button");
    private final By orderButtonTop = By.cssSelector("[class='Button_Button__ra12g']");
    private final By orderButtonMiddle = By.cssSelector(".Button_Middle__1CSJM");
    // MAP  использовал для ParameterizedTest, выбор элемента происходит в зависимости от вопроса.
    // Правильно реализовал или есть проще и лучше способ?
    private final Map<Integer, String> FIELD_QUESTIONS = Map.of(
            1, ".//div[1][@class='accordion__item']",
            2, ".//div[2][@class='accordion__item']",
            3, ".//div[3][@class='accordion__item']",
            4, ".//div[4][@class='accordion__item']",
            5, ".//div[5][@class='accordion__item']",
            6, ".//div[6][@class='accordion__item']",
            7, ".//div[7][@class='accordion__item']",
            8, ".//div[8][@class='accordion__item']"
    );
    private final Map<Integer, String> FIELD_ANSWER = Map.of(
            1, ".//div[@id='accordion__panel-0']/p",
            2, ".//div[@id='accordion__panel-1']/p",
            3, ".//div[@id='accordion__panel-2']/p",
            4, ".//div[@id='accordion__panel-3']/p",
            5, ".//div[@id='accordion__panel-4']/p",
            6, ".//div[@id='accordion__panel-5']/p",
            7, ".//div[@id='accordion__panel-6']/p",
            8, ".//div[@id='accordion__panel-7']/p"
    );


    public MainPage(String url) {
        open(url);
    }

    public MainPage clickQuestion(int numberQuestion) {
        // close Cookie, в некоторых кейсах мешают куки.
        // Не нравится решение закрывать куки сдесь подскажите как лучше сделать,
        // так же есть дубль этого кода в следующем ТЕСТЕ для закрытия кук
        if (numberQuestion == 1) {
            clickButton(cookieButton);
        }
        clickButton(FIELD_QUESTIONS.get(numberQuestion));
        return this;
    }

    public String getTextAnswer(int numberQuestion) {
        return getText(FIELD_ANSWER.get(numberQuestion));
    }

    public void clickOrder(String orderButton) {
        if (Objects.equals(orderButton, "orderButtonTop")) {
            clickButton(cookieButton);
        }
        clickButton(orderButton.equals("orderButtonTop") ? orderButtonTop : orderButtonMiddle);
    }
}
