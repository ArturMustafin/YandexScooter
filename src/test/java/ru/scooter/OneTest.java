package ru.scooter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.scooter.Page.MainPage;


public class OneTest extends BaseTest{
    private final static String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    /**
     * заменил junit на junit.jupiter тут присутс
     */
    @ParameterizedTest(name = "{0} - question")
    @ValueSource(ints = {
            1, 2, 3, 4, 5, 6, 7, 8
    })
    public void checkQuestionsAboutImportantTest(int numberQuestion){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.clickQuestion(numberQuestion);
        String textAnswer = mainPage.getTextAnswer(numberQuestion);

        Assertions.assertTrue(textAnswer.contains(MainPage.answerToQuestion.get(numberQuestion)));
    }

}
