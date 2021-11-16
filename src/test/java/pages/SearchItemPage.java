package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class SearchItemPage extends BasePage {

    public SearchItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search_query_top")
    WebElement searchTop;

    @FindBy(css = ".btn.btn-default.button-search")
    WebElement buttonSearch;

    @FindBy(css = ".top-pagination-content.clearfix .product-count")
    WebElement productCount;

    @FindBy(css = ".page-heading.product-listing .heading-counter")
    static
    List<WebElement> headingCounter;

    @FindBy(css = ".right-block .product-name")
    static
    List<WebElement> resultOfSearching;

    @FindBy(css = ".right-block .price.product-price")
    static
    List<WebElement> blousePrice;

    public void clickOnSearch() {
        searchTop.click();
    }

    public void enterSearchWords(String searchWords){
        searchTop.sendKeys(searchWords);
    }

    public void clickOnSearchButton() {
        buttonSearch.click();
        wait.until(ExpectedConditions.visibilityOf(productCount));
    }

    public static List<String> getHeadingCounter() {
        return headingCounter.stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
    }

    public static List<String> getResultOfSearching() {
        return resultOfSearching.stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
    }

    public static List<String> getItemPriceResult() {
        return blousePrice.stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
    }



}
