package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


/**
 * @author MStyczen
 * Base POM class which can be inherited by other pages.
 * This class possess fundamental methods methods.
 */

public class BasePage {
    WebDriver driver;
    private Actions builder;

    BasePage(WebDriver driver, Actions builder) {
        this.driver = driver;
        this.builder = builder;
    }

    BasePage(WebDriver driver) {}

    void click(By element) {
        driver.findElement(element).click();
    }

    void hoverOver(By element) {
        builder.moveToElement(driver.findElement(element)).build().perform();
    }

    void write(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    String getUrl() {
        return driver.getCurrentUrl();
    }


    boolean isElementExist(By element) {

        return driver.findElement(element).isDisplayed();

    }

    String readText(By element) {
        return driver.findElement(element).getText();
    }

    public static void waitForLoad(int time) throws InterruptedException {
        Thread.sleep(time);
    }



}