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

import static com.codeborne.selenide.Selenide.open;

public class OrderVerificationTest {
    private final static String DATE_NOW = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
    private final static String UNDERGROUND = "Люблино";
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
        open(MainPage.URL_HOME, MainPage.class)
                .clickOrder(orderButton);

        String statusOrder = new OrderPage()
                .makeOrderWithMandatoryField(NAME, SURNAME, ADDRESS, PHONE, UNDERGROUND, DATE_NOW)
                .getTextStatus();

        Assertions.assertEquals("Заказ оформлен", statusOrder);
    }
}
