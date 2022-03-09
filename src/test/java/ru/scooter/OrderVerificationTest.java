package ru.scooter;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.scooter.Page.MainPage;
import ru.scooter.Page.OrderPage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class OrderVerificationTest extends BaseTest {
    private final static String URL_HOME = "https://qa-scooter.praktikum-services.ru/";
    private final static String DATE_NOW = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
    private final static String UNDERGROUND = "Люблино";
    // Faker генератор случайных данных
    private final static Faker faker = new Faker(new Locale("ru"));
    private final static String NAME = faker.name().firstName();
    private final static String SURNAME = faker.name().lastName();
    private final static String ADDRESS = faker.address().streetAddress();
    private final static String PHONE = faker.phoneNumber().subscriberNumber(11);


    @ParameterizedTest(name = "Выполнить заказ через - {0}")
    @ValueSource(strings = {
            "orderButtonTop",
            "orderButtonMiddle"
    })
    public void checkBuyScooterTest(String orderButton) {
        new MainPage(URL_HOME)
                .clickOrder(orderButton);

        OrderPage orderPage = new OrderPage()
                .makeOrderWithMandatoryField(NAME, SURNAME, ADDRESS, PHONE, UNDERGROUND, DATE_NOW);
        String statusOrder = orderPage.getTextStatus();

        Assertions.assertEquals("Заказ оформлен", statusOrder);
    }
}
