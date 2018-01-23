package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Page class which object is instantiated after game name is typed into search field
 */

public class SearchResultPage extends BasePage {


    private String playNowButtonDesktop = "o-btn--big";
    private String playNowButtonMobile = "o-btn--full-width";


    public SearchResultPage(WebDriver driver, Actions builder) {
        super(driver, builder);
    }

    public void goToMore() {
        String moreButton = "o-btn--more";
        click(By.className(moreButton));
    }

    public void mouseOver() {

        String gameAfterSearchDesktop = "gc-tile";
        hoverOver(By.className(gameAfterSearchDesktop));
    }
    public void clickPlayNowDesktop() {
        click(By.className(playNowButtonDesktop));
    }

    public void clickPlayNowMobile() {
        click(By.className(playNowButtonMobile));
    }

    public void clickGame() {
        String gameAfterSearchMobile = "tile-mobile__border";
        click(By.className(gameAfterSearchMobile));
    }

    public void gameIsPresentDesktop(String gameName) {
        String gameTitleDesktop = "tile-details__title";
        Assert.assertEquals(readText(By.className(gameTitleDesktop)), gameName);
    }

    public void gameIsPresentMobile(String gameName) {
        String gameTitleMobile = "//*[@id=\"root\"]/div/div[4]/div/header/h3";
        Assert.assertEquals(readText(By.xpath(gameTitleMobile)), gameName);
    }

    public void playNowIsPresentDesktop(String buttonName) {
        Assert.assertEquals(readText(By.className(playNowButtonDesktop)), buttonName);
    }

    public void playNowIsPresentMobile(String buttonName) {
        Assert.assertEquals(readText(By.className(playNowButtonMobile)), buttonName);
    }
}