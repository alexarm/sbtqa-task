package ru.sbtqa.task.pages.YandexMarket;

import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.task.blocks.YandexMarket.HeaderBlock;
import ru.sbtqa.task.blocks.YandexMarket.TopMenuBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@PageEntry(title = "Яндекс Маркет")
public class YmMainPage extends Page {

    @ElementTitle("Меню поиска")
    public HeaderBlock headerBlock;

    @ElementTitle("Разделы")
    public TopMenuBlock topMenuBlock;

    public YmMainPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }
}