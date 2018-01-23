package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MainVegasPage extends BasePage {

    public MainVegasPage(WebDriver driver) { super(driver); }
    public MainVegasPage(WebDriver driver, Actions builder) { super(driver,builder); }

    private String searchButtonXpath = "/html/body/div[3]/div/div/div[2]/div[2]/wf-header/header/div[2]/button";


    public void goToSearchBox(){
        click(By.xpath(searchButtonXpath));
    }

    public void closeIfIntroPopOutAppears(){
        String introPopOutButton = "/html/body/div[5]/div/div[2]/button";
        if(driver.findElements( By.xpath(introPopOutButton) ).size() != 0) {
            click(By.xpath(introPopOutButton));
        }
    }

    /**
     *
     * @param gameName
     */
    public void typeGameToSearch(String gameName){
        String searchInput = "input";
        write(By.tagName(searchInput), gameName); }

    /**
     *
     * @param expectedPage
     */
    public void verifyWHVegasPage(String expectedPage){
        Assert.assertEquals(getUrl(),expectedPage);
    }

    public void verifyExistenceOfMagnifierButton() {
        Assert.assertTrue(isElementExist(By.xpath(searchButtonXpath)));
    }



}
