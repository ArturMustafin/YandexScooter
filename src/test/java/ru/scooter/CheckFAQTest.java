package ru.scooter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.scooter.Page.MainPage;

import java.util.Map;


public class CheckFAQTest extends BaseTest {
    private final static String URL_HOME = "https://qa-scooter.praktikum-services.ru/";
    private final static Map<Integer, String> ANSWER_TO_QUESTION = Map.of(
            1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    );


    @ParameterizedTest(name = "{0} - question")
    @ValueSource(ints = {
            1, 2, 3, 4, 5, 6, 7, 8
    })
    public void checkQuestionsAboutImportantTest(int numberQuestion) {
        MainPage mainPage = new MainPage(URL_HOME)
                // Добавил еще метод проверки перед нажатием, что эл. Существует
                .checkAllElementsOnPagePresent(numberQuestion)
                .clickQuestion(numberQuestion);

        Assertions.assertTrue(mainPage.getTextAnswer(numberQuestion)
                .contains(ANSWER_TO_QUESTION.get(numberQuestion)));
    }
}
