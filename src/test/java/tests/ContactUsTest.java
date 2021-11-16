package tests;

import common.CommonData;
import enums.MessageSubject;
import dto.MessageDto;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactUsFormPage;
import pages.TopMenuPage;
import url.Url;
import common.PageTitles;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactUsTest extends BaseTest {

    private TopMenuPage topMenuPage;
    private ContactUsFormPage contactUsFormPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(Url.BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitles.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        contactUsFormPage = new ContactUsFormPage(driver);
    }


    @Test
    @Order(1)
    public void shouldNotAllowToSendEmptyContactUsForm(){
        topMenuPage.clickOnContactUsLink();
        contactUsFormPage.clickOnSendButton();
        assertThat(contactUsFormPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    @Order(2)
    void shouldNotAllowToSendContactUsFormWithEmailOnly() {
        topMenuPage.clickOnContactUsLink();
        contactUsFormPage.enterEmail(CommonData.EMAIL_ADDRESS);
        contactUsFormPage.clickOnSendButton();

        assertThat(contactUsFormPage.isRedAlertBoxDisplayed()).isTrue();

    }

    @Test
    @Order(3)
    void shouldSendContactUsFormWithValidData() {
        topMenuPage.clickOnContactUsLink();

        MessageDto message = new MessageDto();
        message.setSubject(MessageSubject.WEBMASTER);
        message.setEmail(CommonData.EMAIL_ADDRESS);
        message.setOrderReference(CommonData.ORDER_REFERENCE);
        message.setMessage(CommonData.MESSAGE);
        contactUsFormPage.sendContactUsForm(message);


        assertThat(contactUsFormPage.isGreenAlertBoxDisplayed()).isTrue();
    }
}
