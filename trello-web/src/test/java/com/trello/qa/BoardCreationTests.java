package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    //1. Check that board is successfully creating with valid values NO TEAM
   @Test
    public void createBoardFromBoardButtonNoTeam() throws InterruptedException {
       int before=teamsCounter();
       pathToTheCreatingBoardsFormFromBoardButton();
       String boardTitle="Title1";
       fillTheBoardsFormNoTeam(boardTitle,"private");
       clickCreateBoardBoardSubmitButton();
       Assert.assertTrue(isBoardCreated(boardTitle));
       goHomePage();
       Assert.assertEquals(teamsCounter(), before+1);
    }

    // 2. Check that board is not created after cancelling during creation.
    @Test
    public void cancellingDuringBoardCreation()  {
        int before=teamsCounter();
        pathToTheCreatingBoardsFormFromBoardButton();
        String boardTitle="Title2";
        fillTheBoardsFormNoTeam(boardTitle,"private");
        clickCancelInTheCreatingBoardForm();
        Assert.assertFalse(isBoardCreated(boardTitle));
        Assert.assertEquals(teamsCounter(), before);
    }
      // 3. Check that Access rights are private when choosing Private access.
    @Test
    public void creatingBoardWithPrivateAccess(){
        pathToTheCreatingBoardsFormFromBoardButton();
        fillTheBoardsFormNoTeam("Title3","private");
        clickCreateBoardBoardSubmitButton();
        Assert.assertTrue(isElementPresent(By.cssSelector(".icon-private")));
    }
}
