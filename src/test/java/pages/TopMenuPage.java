package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuPage extends BasePage {

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy(linkText = "Sign in")
    WebElement signInLink;

    @FindBy(linkText = "Women")
    WebElement womenLink;

    @FindBy(id = "subcategories")
    WebElement presenceOfSubcategories;

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnContactUsLink() {
        contactUsLink.click();
    }

    public void clickOnSignInLink() {
        signInLink.click();
    }

    public void clickOnWomenLink() {
        womenLink.click();
        wait.until(ExpectedConditions.visibilityOf(presenceOfSubcategories));
    }


}
