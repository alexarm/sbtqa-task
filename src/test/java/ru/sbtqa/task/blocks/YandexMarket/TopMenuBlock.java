package ru.sbtqa.task.blocks.YandexMarket;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.task.utils.WaitUtils;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@Name("Разделы")
@FindBy(xpath = "//ul[@class='topmenu__list']")
public class TopMenuBlock extends HtmlElement {

    @Name("Разделы")
    @FindBy(xpath = ".//a[contains(@class, 'topmenu__link')]")
    public List<WebElement> categoriesList;

    @Name("Подразделы")
    @FindBy(xpath = ".//a[contains(@class, 'topmenu__subitem')]")
    public List<WebElement> subCategoriesList;

    @ActionTitle("выбирает раздел")
    public void chooseCategory(String categoryName) throws InterruptedException {
        for (WebElement category: categoriesList) {
            if (category.getText().equals(categoryName)) {
                Actions action = new Actions(PageFactory.getWebDriver());
                action
                        .moveToElement(category)
                        .build()
                        .perform();
                break;
            }
        }

    }

    @ActionTitle("выбирает подраздел")
    public void chooseSubCategory(String subCategoryName) throws InterruptedException {
        for (WebElement subCategory: subCategoriesList) {
            if (subCategory.getAttribute("innerText").equals(subCategoryName)) {
                WaitUtils.waitUntilElementIsDisplayed(subCategory);
                subCategory.click();
                break;
            }
        }
    }

}
