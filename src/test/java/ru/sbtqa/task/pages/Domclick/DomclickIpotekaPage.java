package ru.sbtqa.task.pages.Domclick;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.concurrent.TimeUnit;


@PageEntry(title = "Страница ипотеки")
public class DomclickIpotekaPage extends Page {

    @ElementTitle("Стоимость недвижимости")
    @FindBy(xpath = ".//input[@id='estateCost']")
    public TextInput estateCost;

    @ElementTitle("Первоначальный взнос")
    @FindBy(xpath = ".//input[@id='initialFee']")
    public TextInput initialFee;

    @ElementTitle("Страхование жизни")
    @FindBy(xpath = ".//input[@data-test-id='lifeInsurance']/../..")
    public CheckBox lifeInsurance;

    @ElementTitle("Ежемесячный платеж")
    @FindBy(xpath = ".//span[@data-test-id='monthlyPayment']")
    public TextBlock monthlyPayment;

    @Override
    @ActionTitle("ru.sbtqa.tag.pagefactory.fill.field")
    public void fillField(String elementTitle, String text) throws PageException {
        WebElement element = getElementByTitle(elementTitle);
        super.fillField(element, text);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    @ActionTitle("ru.sbtqa.tag.pagefactory.select.checkBox")
    public void setCheckBox(String elementTitle) throws PageException {
        super.setCheckBox(elementTitle);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public DomclickIpotekaPage() throws InterruptedException {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
        PageFactory.getDriver().manage().timeouts().pageLoadTimeout(PageFactory.getTimeOutInSeconds(), TimeUnit.SECONDS);
    }
}
