package tests;

import common.CommonData;
import common.PageTitles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchItemPage;
import url.Url;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageSearchTest extends BaseTest {

    private SearchItemPage searchItemPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(Url.BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitles.HOME_PAGE_TITLE);

        searchItemPage = new SearchItemPage(driver);
    }

    @Test
    void searchTestBlouse() {
        searchItemPage.clickOnSearch();
        searchItemPage.enterSearchWords(CommonData.SEARCH_TEXT);
        searchItemPage.clickOnSearchButton();

        assertThat(searchItemPage.getHeadingCounter()).containsExactly("1 result has been found.");
        assertThat(searchItemPage.getResultOfSearching()).containsExactly("Blouse");
        assertThat(searchItemPage.getItemPriceResult()).isNotNull();
    }
}
