package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.MainVegasPage;
import pages.SearchResultPage;

public class SearchResultTest extends BaseTest {

    /**
     *
     * @param game
     * @throws InterruptedException
     */
    @Parameters({
            "game"
    })
    @Test (groups = "desktop")
    public void testGameAfterSearchScreenDesktop(String game) throws InterruptedException {
        MainVegasPage mainVegasPage = new MainVegasPage(driver, builder);
        SearchResultPage searchResultPage = new SearchResultPage(driver, builder);

        mainVegasPage.closeIfIntroPopOutAppears();
        mainVegasPage.goToSearchBox();
        mainVegasPage.typeGameToSearch(game);
        BasePage.waitForLoad(1000);
        searchResultPage.mouseOver();
        BasePage.waitForLoad(1000);
        searchResultPage.goToMore();
        BasePage.waitForLoad(1000);

        searchResultPage.gameIsPresentDesktop(game);
        searchResultPage.playNowIsPresentDesktop("Play Now");
        driver.close();


    }

    @Parameters({
            "game"
    })
    @Test(groups = "mobile")
    public void testGameAfterSearchScreenMobile(String game) throws InterruptedException {
        MainVegasPage mainVegasPage = new MainVegasPage(driver, builder);
        SearchResultPage searchResultPage = new SearchResultPage(driver, builder);

        mainVegasPage.closeIfIntroPopOutAppears();
        mainVegasPage.goToSearchBox();
        BasePage.waitForLoad(1000);
        mainVegasPage.typeGameToSearch(game);

        BasePage.waitForLoad(1000);

        searchResultPage.clickGame();
        BasePage.waitForLoad(1000);
        searchResultPage.gameIsPresentMobile(game);
        searchResultPage.playNowIsPresentMobile("Play Now");
        driver.close();

    }


}