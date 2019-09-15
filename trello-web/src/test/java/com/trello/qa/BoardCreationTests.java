package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    //1. Check that board is successfully creating with valid values NO TEAM
   @Test
    public void createBoardFromBoardButtonNoTeam() throws InterruptedException {
       int before= app.boardCounter();
       app.pathToTheCreatingBoardsFormFromBoardButton();
       String boardTitle="Title1";
       app.fillTheBoardsFormNoTeam(boardTitle,"private");
       app.clickCreateBoardBoardSubmitButton();
       Assert.assertTrue(app.isBoardCreated(boardTitle));
       app.goHomePage();
       Assert.assertEquals(app.boardCounter(), before+1);
    }

    // 2. Check that board is not created after cancelling during creation.
    @Test
    public void cancellingDuringBoardCreation()  {
        int before= app.boardCounter();
        app.pathToTheCreatingBoardsFormFromBoardButton();
        String boardTitle="Title2";
        app.fillTheBoardsFormNoTeam(boardTitle,"private");
        app.clickCancelInTheCreatingBoardForm();
        Assert.assertFalse(app.isBoardCreated(boardTitle));
        Assert.assertEquals(app.boardCounter(), before);
    }
      // 3. Check that Access rights are private when choosing Private access.
    @Test
    public void creatingBoardWithPrivateAccess(){
        app.pathToTheCreatingBoardsFormFromBoardButton();
        app.fillTheBoardsFormNoTeam("Title3","private");
        app.clickCreateBoardBoardSubmitButton();
        Assert.assertTrue(app.isElementPresent(By.cssSelector(".icon-private")));
    }
}
