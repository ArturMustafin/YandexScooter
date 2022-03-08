package ru.scooter.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Страница сайта "Заказа"
 */
public class OrderPage extends BasePage {
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");
    private final By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By inputUnderground = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By inputDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By period = By.cssSelector(".Dropdown-control");
    private final By week = By.cssSelector(".Dropdown-option");
    private final By buttonNext = By.cssSelector(".Button_Middle__1CSJM");
    private final By buttonOrder = By.cssSelector("[class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By buttonConfirm = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");
    private final By textStatusOrder = By.xpath(".//div[text()='Заказ оформлен']");

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
        setField(inputName, name);
    }

    private void setSurnameInField(String surname) {
        setField(inputSurname, surname);
    }

    private void setAddressInField(String address) {
        setField(inputAddress, address);
    }

    private void setPhoneInField(String phone) {
        setField(inputPhone, phone);
    }

    private void setUndergroundInField(String underground) {
        setField(inputUnderground, underground, Keys.ARROW_DOWN, Keys.ENTER);
    }

    private void clickNextButton() {
        clickButton(buttonNext);
    }

    private void setDateNowInField(String dateNow) {
        setField(inputDate, dateNow, Keys.ENTER);
    }

    private void clickRentalPeriod() {
        clickButton(period);
    }

    private void clickCountDay() {
        clickButton(week);
    }

    private void clickButtonOrder() {
        clickButton(buttonOrder);
    }

    // тут баг в хроме
    private void clickButtonConfirm() {
        clickButton(buttonConfirm);
    }

    public String getTextStatus() {
        return getText(textStatusOrder);
    }
}