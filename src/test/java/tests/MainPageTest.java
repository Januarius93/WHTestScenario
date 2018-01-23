package tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.MainVegasPage;

public class MainPageTest extends BaseTest {
    /**
     *
     * @param url
     * @throws InterruptedException
     */

    @Test  (groups = {"desktop","mobile"})
    @Parameters({"url"})
    public void WHVegasMainTestPage(String url) throws InterruptedException {
        MainVegasPage mainVegasPage = new MainVegasPage(driver,builder);
        BasePage.waitForLoad(2000);

        mainVegasPage.closeIfIntroPopOutAppears();

        mainVegasPage.verifyWHVegasPage(url);

        mainVegasPage.verifyExistenceOfMagnifierButton();
        driver.close();
    }


}
