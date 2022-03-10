package ru.scooter.Page;

import org.openqa.selenium.By;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

/**
 * Главная страница сайта "Самокат"
 */
public class MainPage extends BasePage {
    private final By orderButtonTop = By.cssSelector("[class='Button_Button__ra12g']");
    private final By orderButtonMiddle = By.cssSelector(".Button_Middle__1CSJM");
    private final By textCookie = By.xpath(".//div[text()='И здесь куки! В общем, мы их используем.']");
    private final By buttonCookie = By.xpath(".//button[text()='да все привыкли']");
    private final Map<Integer, String> fieldQuestions = Map.of(
            1, ".//div[1][@class='accordion__item']",
            2, ".//div[2][@class='accordion__item']",
            3, ".//div[3][@class='accordion__item']",
            4, ".//div[4][@class='accordion__item']",
            5, ".//div[5][@class='accordion__item']",
            6, ".//div[6][@class='accordion__item']",
            7, ".//div[7][@class='accordion__item']",
            8, ".//div[8][@class='accordion__item']"
    );
    private final Map<Integer, String> fieldAnswer = Map.of(
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
        closeCookiesPopup();
    }

    public void closeCookiesPopup(){
        if(checkTextExist(textCookie)){
            clickButton(buttonCookie);
        }
    }

    public MainPage clickQuestion(int numberQuestion) {
        clickButton(fieldQuestions.get(numberQuestion));
        return this;
    }

    public MainPage checkAllElementsOnPagePresent(int numberQuestion){
        isElementDisplayed(fieldQuestions.get(numberQuestion));
        return this;
    }

    public String getTextAnswer(int numberQuestion) {
        return getText(fieldAnswer.get(numberQuestion));
    }

    public void clickOrder(String orderButton) {
        clickButton(orderButton.equals("orderButtonTop") ? orderButtonTop : orderButtonMiddle);
    }
}
