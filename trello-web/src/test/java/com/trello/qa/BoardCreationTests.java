package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

   @Test
    public void createBoardFromBoardButton(){
       pathToTheCreatingBoardsForm();
       fillTheBoardsFormNoTeam("Title1","private");
       click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
       Assert.assertTrue(isBoardCreated("Title1"));
    }
}

