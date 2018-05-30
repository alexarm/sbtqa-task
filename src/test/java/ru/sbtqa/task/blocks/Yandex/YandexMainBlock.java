package ru.sbtqa.task.blocks.Yandex;

import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

@Name("Основной блок")
@FindBy(xpath = "//div[contains(@class, 'container__search')]")
public class YandexMainBlock extends HtmlElement{

    @Name("Строка поиска")
    @FindBy(xpath = ".//input[contains(@class, 'input__input')]")
    public TextInput searchString;

    @Name("Найти")
    @FindBy(xpath = ".//span[text()='Найти']")
    public TextInput searchButton;

    @Name("Сервисы")
    @FindBy(xpath = ".//a[contains(@class, 'home-tabs__link')]")
    public List<Link> servicesLinks;

    @ActionTitle("открывает сервис")
    public void openYandexService(String service) {
        for (Link yandexService: servicesLinks) {
            if (yandexService.getText().equals(service)) {
                yandexService.click();
                break;
            }
        }
    }

}
