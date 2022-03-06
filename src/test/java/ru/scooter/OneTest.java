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
import java.util.Map;


public class OneTest extends BaseTest {
    private final static String URL_HOME = "https://qa-scooter.praktikum-services.ru/";
    private static final Map<Integer, String> ANSWER_TO_QUESTION = Map.of(
            1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    );
    // Faker генератор случайных данных
    private final String DATE_NOW = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
    private final Faker faker = new Faker(new Locale("ru"));
    private final String NAME = faker.name().firstName();
    private final String SURNAME = faker.name().lastName();
    private final String ADDRESS = faker.address().streetAddress();
    private final String PHONE = faker.phoneNumber().subscriberNumber(11);
    private final String UNDERGROUND = "Люблино";

    /**
     * В задание требовалось использовать junit заменил на junit.jupiter
     * тут присутствует @ParameterizedTest
     */
    @ParameterizedTest(name = "{0} - question")
    @ValueSource(ints = {
            1, 2, 3, 4, 5, 6, 7, 8
    })
    public void checkQuestionsAboutImportantTest(int numberQuestion) {
        // паттерн Chain of invocations, использовать методы класса MainPage через "."
        MainPage mainPage = new MainPage(URL_HOME)
                .clickQuestion(numberQuestion);

        //сложный на мой взгляд ассерт
        Assertions.assertTrue(/*получил с ui ответ на вопрос*/mainPage.getTextAnswer(numberQuestion)
                .contains(/*и проверяю со своей константой*/ANSWER_TO_QUESTION.get(numberQuestion)));
    }


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
