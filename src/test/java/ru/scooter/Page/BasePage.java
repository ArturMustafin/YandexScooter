package ru.scooter.Page;


import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    public void clickButton(String element){
        $(byXpath(element)).click();
    }
}
