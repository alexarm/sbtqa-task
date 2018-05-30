package ru.sbtqa.task.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.pagefactory.PageFactory;

public class WaitUtils {

    public static void waitUntilElementIsDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(PageFactory.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementIsStale(WebElement element) {
        WebDriverWait wait = new WebDriverWait(PageFactory.getDriver(), 10);
        wait.until(ExpectedConditions.stalenessOf(element));
    }
}
