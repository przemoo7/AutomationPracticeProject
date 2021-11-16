package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInFormPage extends BasePage {

    public SignInFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    WebElement createAccount;

    @FindBy(css = "#SubmitCreate")
    WebElement createAccountButton;

    @FindBy(css = ".page-heading")
    WebElement pageHeading;


    public void enterEmailRegister(String email) {
        wait.until(ExpectedConditions.visibilityOf(createAccount));
        createAccount.sendKeys(email);
    }

    public void createAccountButtonClick() {
        createAccountButton.click();
        wait.until(ExpectedConditions.visibilityOf(pageHeading));
    }

}
