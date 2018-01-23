package tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginWindowPage;
import pages.MainVegasPage;
import pages.SearchResultPage;

public class LoginFormTest extends BaseTest {


    /**
     * @param url
     * @param game
     * @throws InterruptedException
     * Main test which verifies actual scenario. Test might be too long by looking at @param mode one test could be
     * sufficient to both desktop and emulation
     */
    @Parameters({
            "url",
            "game",
            "reportPath"
    })

    @Test (groups = { "desktop" })
    public void loginWindowTestDesktop(String url, String game, String reportPath) throws InterruptedException {
        MainVegasPage mainVegasPage = new MainVegasPage(driver, builder);
        SearchResultPage searchResultPage = new SearchResultPage(driver, builder);
        LoginWindowPage loginWindowPage = new LoginWindowPage(driver, builder);
        ExtentReports reports = new ExtentReports(reportPath, true);
        ExtentTest test = reports.startTest("Verify game search and login - Desktop");

        BasePage.waitForLoad(1000);
        mainVegasPage.closeIfIntroPopOutAppears();
        test.log(LogStatus.PASS,"Intro pop out closed");
        mainVegasPage.verifyWHVegasPage(url);
        mainVegasPage.verifyExistenceOfMagnifierButton();
        test.log(LogStatus.PASS,"Search button exits");
        mainVegasPage.goToSearchBox();
        BasePage.waitForLoad(1000);
        mainVegasPage.typeGameToSearch(game);

        BasePage.waitForLoad(1000);

        searchResultPage.mouseOver();
        BasePage.waitForLoad(1000);
        searchResultPage.goToMore();
        searchResultPage.gameIsPresentDesktop(game);
        test.log(LogStatus.PASS,game + " game is present");
        searchResultPage.playNowIsPresentDesktop("Play Now");
        BasePage.waitForLoad(2000);
        searchResultPage.clickPlayNowDesktop();

        BasePage.waitForLoad(2000);
        loginWindowPage.verifyUserNameField();
        loginWindowPage.verifyPasswordField();
        loginWindowPage.verifyLoginButton();
        test.log(LogStatus.PASS,"Log in form is displayed");
        reports.flush();
        reports.endTest(test);
        driver.close();

    }

    @Parameters({
            "url",
            "game",
            "reportPath"
    })
    @Test (groups = {"mobile"})
    public void loginWindowTestMobile(String url, String game, String reportPath) throws InterruptedException {
        MainVegasPage mainVegasPage = new MainVegasPage(driver, builder);
        SearchResultPage searchResultPage = new SearchResultPage(driver, builder);
        LoginWindowPage loginWindowPage = new LoginWindowPage(driver, builder);
        ExtentReports reports = new ExtentReports(reportPath, true);
        ExtentTest test = reports.startTest("Verify game search and login - Mobile");


        BasePage.waitForLoad(1000);
        mainVegasPage.closeIfIntroPopOutAppears();
        test.log(LogStatus.PASS,"Intro pop out closed");
        mainVegasPage.verifyWHVegasPage(url);
        mainVegasPage.verifyExistenceOfMagnifierButton();
        test.log(LogStatus.PASS,"Search button exits");
        mainVegasPage.goToSearchBox();
        BasePage.waitForLoad(1000);
        mainVegasPage.typeGameToSearch(game);

        BasePage.waitForLoad(1000);

        searchResultPage.clickGame();
        BasePage.waitForLoad(1000);
        searchResultPage.gameIsPresentMobile(game);
        test.log(LogStatus.PASS,game + " game is present");
        searchResultPage.playNowIsPresentMobile("Play Now");
        searchResultPage.clickPlayNowMobile();

        BasePage.waitForLoad(2000);
        loginWindowPage.verifyUserNameField();
        loginWindowPage.verifyPasswordField();
        loginWindowPage.verifyLoginButton();
        test.log(LogStatus.PASS,"Log in form is displayed");
        reports.flush();
        reports.endTest(test);
        driver.close();

    }
}