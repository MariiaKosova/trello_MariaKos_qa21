package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        openSite("https://trello.com");
        login("mskosova.qa@gmail.com","StrangerThings-18");

    }

    public void login(String email, String password) {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("[type=email]"), email);
        type (By.cssSelector("[type=password]"),password);
        click(By.id("login"));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void openSite(String url) {
        driver.get(url);
    }

    public void type(By locator, String text){
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    protected void pathToTheCreatingBoardsFormFromBoardButton() {
        click(By.cssSelector("[data-test-id='header-boards-menu-button']"));
        click(By.cssSelector("[data-test-id='header-boards-menu-create-board']"));
    }

    public void fillTheBoardsFormNoTeam(String title, String status) {
        type(By.cssSelector("[data-test-id='header-create-board-title-input']"),title);
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        click(By.cssSelector("#layer-manager-popover nav li:first-child button"));
       chooseStatusInTheBoardsFormNoTeam(status);

    }

    public void chooseStatusInTheBoardsFormNoTeam(String status) {
      click(By.cssSelector("._1Lkx3EjS3wCrs7"));
       if (status.equals("private")){
           click(By.cssSelector("#layer-manager-popover nav li:first-child button"));
       }
       if (status.equals("public")){
           click(By.cssSelector(".pop-over-list li:nth-child(2)"));
           click(By.cssSelector("#layer-manager-popover nav li:nth-child(2) button"));
       }
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public boolean isBoardCreated(String boardName) {
        return isElementPresent(By.cssSelector(".board-tile-details [title="+boardName+"]"));
    }

    public int teamsCounter() {
       return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size();
    }

    protected void clickCreateBoardBoardSubmitButton() {
        click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
    }

    public void goHomePage() throws InterruptedException {
        Thread.sleep(10000);
       click(By.cssSelector("[href='/']"));
       click(By.cssSelector("[href='/']"));
       driver.navigate().refresh();
    }

    protected void clickCancelInTheCreatingBoardForm() {
        click(By.cssSelector("._1rhhEuk7pUqNV_ [name='close']"));
    }
}
