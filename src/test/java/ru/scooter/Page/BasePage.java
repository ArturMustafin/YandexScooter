package ru.scooter.Page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public abstract class BasePage {

    protected Boolean checkTextExist(By element) {
        return $(element).exists();
    }

    protected void clickButton(String element) {
        $(byXpath(element)).click();
    }

    protected void clickButton(By element) {
        $(element).click();
    }

    protected String getText(String element) {
        return $(byXpath(element)).getText();
    }

    protected String getText(By element) {
        return $(element).getText();
    }

    protected void setField(By element, String content) {
        $(element).setValue(content);
    }

    protected void setField(By element, String content, CharSequence key1) {
        $(element).setValue(content).sendKeys(key1);
    }

    protected void setField(By element, String content, CharSequence key1, CharSequence key2) {
        $(element).setValue(content).sendKeys(key1, key2);
    }

    public void isElementDisplayed(String element) {
        assertTrue($(byXpath(element)).isDisplayed());
    }

}
