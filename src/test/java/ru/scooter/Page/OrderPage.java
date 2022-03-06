package ru.scooter.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Страница сайта "Заказа"
 */
public class OrderPage extends BasePage {
    private final By INPUT_NAME = By.xpath(".//input[@placeholder='* Имя']");
    private final By INPUT_SURNAME = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By INPUT_ADDRESS = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By INPUT_PHONE = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By INPUT_UNDERGROUND = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By INPUT_DATE = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By PERIOD = By.cssSelector(".Dropdown-control");
    private final By WEEK = By.cssSelector(".Dropdown-option");
    private final By BUTTON_NEXT = By.cssSelector(".Button_Middle__1CSJM");
    private final By BUTTON_ORDER = By.cssSelector("[class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By BUTTON_CONFIRM = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");
    private final By TEXT_STATUS_ORDER = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderPage makeOrderWithMandatoryField(String name, String surname, String address,
                                                 String phone, String underground, String dateNow) {
        // 1-часть. Для кого самокат
        setNameInField(name);
        setSurnameInField(surname);
        setAddressInField(address);
        setPhoneInField(phone);
        setUndergroundInField(underground);
        clickNextButton();

        // 2-часть. Про аренду
        setDateNowInField(dateNow);
        clickRentalPeriod();
        clickCountDay();
        clickButtonOrder();
        clickButtonConfirm(); // тут баг в хроме
        return this;
    }

    private void setNameInField(String name) {
        setField(INPUT_NAME, name);
    }

    private void setSurnameInField(String surname) {
        setField(INPUT_SURNAME, surname);
    }

    private void setAddressInField(String address) {
        setField(INPUT_ADDRESS, address);
    }

    private void setPhoneInField(String phone) {
        setField(INPUT_PHONE, phone);
    }

    private void setUndergroundInField(String underground) {
        setField(INPUT_UNDERGROUND, underground, Keys.ARROW_DOWN, Keys.ENTER);
    }

    private void clickNextButton() {
        clickButton(BUTTON_NEXT);
    }

    private void setDateNowInField(String dateNow) {
        setField(INPUT_DATE, dateNow, Keys.ENTER);
    }

    private void clickRentalPeriod() {
        clickButton(PERIOD);
    }

    private void clickCountDay() {
        clickButton(WEEK);
    }

    private void clickButtonOrder() {
        clickButton(BUTTON_ORDER);
    }

    // тут баг в хроме
    private void clickButtonConfirm() {
        clickButton(BUTTON_CONFIRM);
    }

    public String getTextStatus() {
        return getText(TEXT_STATUS_ORDER);
    }
}