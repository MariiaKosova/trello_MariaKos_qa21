package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BoardHelper extends HalperBase {
    public BoardHelper(WebDriver driver) {
        super(driver);
    }

    public void pathToTheCreatingBoardsFormFromBoardButton() {
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

    public boolean isBoardCreated(String boardName) {
        return isElementPresent(By.cssSelector(".board-tile-details [title="+boardName+"]"));
    }

    public int boardCounter() {
       return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size();
    }

    public void clickCreateBoardBoardSubmitButton() {
        click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
    }

    public void clickCancelInTheCreatingBoardForm() {
        click(By.cssSelector("._1rhhEuk7pUqNV_ [name='close']"));
    }

    public void chooseAndDeleteFirstBoard() {
        chooseFirstBoard();
        if (isElementPresent(By.cssSelector(".board-menu.js-fill-board-menu.hide"))){
            click(By.cssSelector(".js-show-sidebar"));
        }
        click(By.cssSelector(".js-open-more"));
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".negate"));
        click(By.cssSelector(".js-delete[href='#']"));
        click(By.cssSelector(".negate"));

    }

    public void chooseFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li[1]"));
    }


    public void changeBoardName(String boardTitle) {
        driver.findElement(By.cssSelector(".js-rename-board")).click();
        driver.findElement(By.cssSelector(".js-board-name-input")).sendKeys(boardTitle);
        driver.findElement(By.id("board")).click();

    }
}
