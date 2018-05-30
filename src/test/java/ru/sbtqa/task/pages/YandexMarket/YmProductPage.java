package ru.sbtqa.task.pages.YandexMarket;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.task.blocks.YandexMarket.HeaderBlock;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@PageEntry(title = "Страница товара")
public class YmProductPage extends Page {

    private HeaderBlock headerBlock;

    @Name("Название")
    @FindBy(xpath = "//h1")
    public HtmlElement name;

    @ActionTitle("проверяет, что имя содержит поисковый запрос")
    public void checkName() {
        Assert.assertTrue(name.getText().contains(YmSearchedProductsPage.productNames.get(0)));
    }

    public YmProductPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }
}
