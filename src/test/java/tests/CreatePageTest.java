package tests;

import common.CommonData;
import common.PageTitles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateAccountPage;
import pages.SignInFormPage;
import pages.TopMenuPage;
import url.Url;

import static org.assertj.core.api.Assertions.assertThat;

public class CreatePageTest extends BaseTest {

    private TopMenuPage topMenuPage;
    private SignInFormPage signInFormPage;
    private CreateAccountPage createAccountPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(Url.BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitles.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        signInFormPage = new SignInFormPage(driver);
        createAccountPage = new CreateAccountPage(driver);
    }

    @Test
    void createAccountCorrectTest() {
        topMenuPage.clickOnSignInLink();
        signInFormPage.enterEmailRegister(CommonData.EMAIL_ADDRESS);
        signInFormPage.createAccountButtonClick();
        createAccountPage.mrTitleClick();
        createAccountPage.enterFirstNameField();
        createAccountPage.enterLastnameField();
        createAccountPage.enterNewPassword();
        createAccountPage.enterDateOfBirth();
        createAccountPage.enterAddressInformation();
        createAccountPage.registerButtonClick();
        assertThat(CreateAccountPage.isMyAccountSpanDisplayed()).isTrue();
    }

    @Test
    void shouldNotAllowToSignInWithoutEmail(){
        topMenuPage.clickOnSignInLink();
        signInFormPage.createAccountButtonClick();
        assertThat(CreateAccountPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    void shouldNotAllowToSignInWithWrongEmail() {
        topMenuPage.clickOnSignInLink();
        signInFormPage.enterEmailRegister("mail.com");
        signInFormPage.createAccountButtonClick();
        assertThat(CreateAccountPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    void shouldNotAllowToSignInWithExistingEmail() {
        topMenuPage.clickOnSignInLink();
        signInFormPage.enterEmailRegister("test@test.pl");
        signInFormPage.createAccountButtonClick();
        assertThat(CreateAccountPage.isRedAlertBoxDisplayed()).isTrue();
    }
}
