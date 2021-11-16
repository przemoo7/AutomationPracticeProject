package pages;

import common.CommonData;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_gender1")
    WebElement mrTitleRadioButton;

    @FindBy(id = "id_gender2")
    WebElement mrsTitleRadioButton;

    @FindBy(id= "customer_firstname")
    WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    WebElement lastnameField;

    @FindBy(id  = "passwd")
    WebElement passwordField;

    @FindBy(id = "days")
    static
    WebElement dayOfBirth;

    @FindBy(id = "months")
    static
    WebElement monthOfBirth;

    @FindBy(id = "years")
    static
    WebElement yearOfBirth;

    @FindBy(id = "firstname")
    WebElement addressFirstNameField;

    @FindBy(id = "lastname")
    WebElement addressLastNameField;

    @FindBy(id = "address1")
    WebElement addressField;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id ="id_state")
    static
    WebElement stateField;

    @FindBy(id ="postcode")
    WebElement postZipCodeField;

    @FindBy(id ="id_country")
    static
    WebElement countryField;

    @FindBy(id ="phone_mobile")
    WebElement mobilePhoneField;

    @FindBy(id= "submitAccount")
    WebElement registerButton;

    @FindBy(css = ".navigation_page:contains(\"My account\")")
    static
    WebElement correctMyAccountPage;

    @FindBy(css = "#center_column .alert.alert-danger")
    public static
    WebElement redAlertBox;


    public void mrTitleClick(){
        wait.until(ExpectedConditions.visibilityOf(mrTitleRadioButton));
        mrTitleRadioButton.click();
    }

    public void MrsTitleClick(){
        wait.until(ExpectedConditions.visibilityOf(mrsTitleRadioButton));
        mrsTitleRadioButton.click();
    }

    public void enterFirstNameField(){
        firstNameField.sendKeys(CommonData.FIRSTNAME);
    }

    public void enterLastnameField(){
        lastnameField.sendKeys(CommonData.LASTNAME);
    }

    public void enterNewPassword(){
        passwordField.sendKeys(CommonData.PASSWORD);
    }

    public void enterDateOfBirth(){
        Select dayOfBirth = new Select(CreateAccountPage.dayOfBirth);
        dayOfBirth.selectByIndex(2);

        Select monthOfBirth = new Select(CreateAccountPage.monthOfBirth);
        monthOfBirth.selectByIndex(3);

        Select yearOfBirth = new Select(CreateAccountPage.yearOfBirth);
        yearOfBirth.selectByValue("1991");
    }

    public void enterAddressInformation(){
//        addressFirstNameField.sendKeys(CommonData.FIRSTNAME);
//        addressLastNameField.sendKeys(CommonData.LASTNAME);
        addressField.sendKeys(CommonData.ADDRESS);
        cityField.sendKeys(CommonData.CITY);

        Select stateField = new Select(CreateAccountPage.stateField);
        stateField.selectByIndex(3);

        postZipCodeField.sendKeys(CommonData.ZIPCODE);

        Select countryField = new Select(CreateAccountPage.countryField);
        countryField.selectByValue("21");

        mobilePhoneField.sendKeys(CommonData.MOBILEPHONE);
    }

    public void registerButtonClick() {
        registerButton.click();
    }

    public static boolean isMyAccountSpanDisplayed() {
        return isProperWebelementDisplayed(correctMyAccountPage);
    }

    public static boolean isProperWebelementDisplayed(WebElement box) {
        wait.until(ExpectedConditions.visibilityOf(box));

        boolean isDisplayed = false;
        try {
            isDisplayed = box.isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return isDisplayed;
    }

    public static boolean isRedAlertBoxDisplayed() {
        return isProperWebelementDisplayed(redAlertBox);
    }
}

