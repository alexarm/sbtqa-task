package ru.sbtqa.task.pages.YandexMarket;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.task.blocks.YandexMarket.AdvancedSearchBlock;
import ru.sbtqa.task.blocks.YandexMarket.HeaderBlock;
import ru.sbtqa.task.elements.YandexMarket.ProductCard;
import ru.sbtqa.task.utils.WaitUtils;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.ArrayList;
import java.util.List;

@PageEntry(title = "Результаты поиска товаров")
public class YmSearchedProductsPage extends Page {

    public static ArrayList<String> productNames;

    @ElementTitle("Меню поиска")
    private HeaderBlock headerBlock;

    @ElementTitle("Расширенный поиск")
    private AdvancedSearchBlock advancedSearchBlock;

    @ElementTitle("Список товаров")
    @FindBy(xpath = ".//div[contains(@class,'n-snippet-card2 ')]")
    private List<ProductCard> productCards;

    public YmSearchedProductsPage(){
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }


    @ActionTitle("проверяет присутствие продукта")
    public void compareProductCost(String productName){

        for (ProductCard card: productCards) {
            if(card.getProductName().toLowerCase().contains(productName.toLowerCase())){
                return;
            }
        }

        Assert.fail("Продукт " + productName +  " не был найден");
    }

    @ActionTitle("проверяет присутствие сохраненного продукта")
    public void compareProductCost(){

        for (ProductCard card: productCards) {
            if(card.getProductName().toLowerCase().contains(productNames.get(0).toLowerCase())){
                return;
            }
        }

        Assert.fail("Продукт " + productNames.get(0) +  " не был найден");
    }

    @ActionTitle("проверяет что продуктов больше 10")
    public void checkProductQuantity(){
        Assert.assertTrue(productCards.size() > 1);
    }

    @ActionTitle("запоминает названия всех продуктов")
    public void saveAllProductNames() throws InterruptedException {
        WaitUtils.waitUntilElementIsStale(productCards.get(0));
        productNames = new ArrayList<>();
        for (ProductCard productCard: productCards) {
            productNames.add(productCard.getProductName());
        }
    }

    @ActionTitle("выполняет поиск по первому продукту")
    public void searchByFirstProduct() {
        headerBlock.startSearch(productNames.get(0));
    }

}
