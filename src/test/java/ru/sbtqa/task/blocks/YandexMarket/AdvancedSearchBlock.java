package ru.sbtqa.task.blocks.YandexMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.task.utils.WaitUtils;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

@Name("Расширенный поиск")
@FindBy(xpath = "//div[@id='search-prepack']")
public class AdvancedSearchBlock extends HtmlElement {
    @FindBy(id = "glpricefrom")
    public TextInput priceFrom;

    @FindBy(id = "glpriceto")
    public TextInput priceTo;

    @Name("Показать всех")
    @FindBy(xpath = ".//legend[text()='Производитель']/..//footer/a[text()='Показать всё']")
    public Link showAll;

    @Name("Ввод производителя")
    @FindBy(id = "7893318-suggester")
    public TextInput inputCompany;

    @FindBy(xpath = ".//legend[text()='Производитель']/..//li//label/input")
    public List<CheckBox> companies;


    @ActionTitle("выбирает производителя")
    public void setCompany(String name) throws InterruptedException {
        if (showAll.exists()) {
            showAll.click();
        }
        inputCompany.clear();
        inputCompany.sendKeys(name);
        WaitUtils.waitUntilElementIsStale(companies.get(0));
        for (CheckBox company: companies) {
            if (company.getAttribute("name").equals("Производитель " + name) && company.isEnabled()) {
                company.findElement(By.xpath("./..")).click();
            }
        }
    }

    @ActionTitle("выбирает цену до")
    public void setPriceTo(String price) {
        priceTo.sendKeys(price);
    }

    @ActionTitle("выбирает цену от")
    public void setPriceFrom(String price) {
        priceFrom.sendKeys(price);
    }
}
