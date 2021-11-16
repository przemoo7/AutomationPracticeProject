package tests;

import common.PageTitles;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TopMenuPage;
import pages.WomenItemsPage;
import url.Url;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WomenPageTest extends BaseTest {

    private TopMenuPage topMenuPage;
    private WomenItemsPage womenItemPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(Url.BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitles.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        womenItemPage = new WomenItemsPage(driver);

    }

    @Test
    public void shouldSeeTheListOfPrices() {
        WomenItemsPage.clickOnWomensButton();

        List<Double> WomenPricesList = WomenItemsPage.getProductPrices();

        List<Double> listOfPricesLowerOrEqualZero = WomenPricesList.stream()
                .filter(el -> el <= 0)
                .collect(Collectors.toList());

        assertThat(listOfPricesLowerOrEqualZero).isEmpty();
    }
}
