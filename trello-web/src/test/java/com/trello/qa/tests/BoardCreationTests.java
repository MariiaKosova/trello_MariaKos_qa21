package com.trello.qa.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    //1. Check that board is successfully creating with valid values NO TEAM
   @Test
    public void createBoardFromBoardButtonNoTeam() throws InterruptedException {
       int before= app.getBoardhelper().boardCounter();
       app.getBoardhelper().pathToTheCreatingBoardsFormFromBoardButton();
       String boardTitle="Title1";
       app.getBoardhelper().fillTheBoardsFormNoTeam(boardTitle,"private");
       app.getBoardhelper().clickCreateBoardBoardSubmitButton();
       Assert.assertTrue(app.getBoardhelper().isBoardCreated(boardTitle));
       app.getBoardhelper().goHomePage();
       Assert.assertEquals(app.getBoardhelper().boardCounter(), before+1);
    }

    // 2. Check that board is not created after cancelling during creation.
    @Test
    public void cancellingDuringBoardCreation()  {
        int before= app.getBoardhelper().boardCounter();
        app.getBoardhelper().pathToTheCreatingBoardsFormFromBoardButton();
        String boardTitle="Title2";
        app.getBoardhelper().fillTheBoardsFormNoTeam(boardTitle,"private");
        app.getBoardhelper().clickCancelInTheCreatingBoardForm();
        Assert.assertFalse(app.getBoardhelper().isBoardCreated(boardTitle));
        Assert.assertEquals(app.getBoardhelper().boardCounter(), before);
    }
      // 3. Check that Access rights are private when choosing Private access.
    @Test
    public void creatingBoardWithPrivateAccess(){
        app.getBoardhelper().pathToTheCreatingBoardsFormFromBoardButton();
        app.getBoardhelper().fillTheBoardsFormNoTeam("Title3","private");
        app.getBoardhelper().clickCreateBoardBoardSubmitButton();
        Assert.assertTrue(app.getBoardhelper().isElementPresent(By.cssSelector(".icon-private")));
    }
}
