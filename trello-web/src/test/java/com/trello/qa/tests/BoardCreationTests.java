package com.trello.qa.tests;

import com.trello.qa.model.BoardData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validBoardData(){
        List<Object[]> boardList = new ArrayList<>();
        boardList.add(new Object[]{"name1", "private"});
        boardList.add(new Object[]{"NAME1", "private"});
//        boardList.add(new Object[]{"123"});
//        boardList.add(new Object[]{"N@$%#1"});

        return boardList.iterator();
    }

    // duplicated createBoardFromBoardButtonNoTeam() method to test an Iterator
    @Test(dataProvider = "validBoardData")
    public void createBoardNoTeamDataProvider(String title, String status) throws InterruptedException {
        BoardData boardData = new BoardData().setTitle(title).setStatus(status);
        int before= app.getBoardhelper().boardCounter();
        app.getBoardhelper().pathToTheCreatingBoardsFormFromBoardButton();
        //String boardTitle="Title1";
       // app.getBoardhelper().createBoardNoTeam(title);
        app.getBoardhelper().fillTheBoardsFormNoTeam(boardData);
        app.getBoardhelper().clickCreateBoardBoardSubmitButton();
        Assert.assertTrue(app.getBoardhelper().isBoardCreated(title));
        app.getBoardhelper().goHomePage();
        Assert.assertEquals(app.getBoardhelper().boardCounter(), before+1);
    }

    //1. Check that board is successfully creating with valid values NO TEAM
   @Test
    public void createBoardFromBoardButtonNoTeam() throws InterruptedException {
       int before= app.getBoardhelper().boardCounter();
       app.getBoardhelper().pathToTheCreatingBoardsFormFromBoardButton();
       String boardTitle="Title1";
       app.getBoardhelper().createBoardNoTeam(boardTitle);
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
        app.getBoardhelper().fillTheBoardsFormNoTeam(new BoardData().setTitle(boardTitle).setStatus("private"));
        app.getBoardhelper().clickCancelInTheCreatingBoardForm();
        Assert.assertFalse(app.getBoardhelper().isBoardCreated(boardTitle));
        Assert.assertEquals(app.getBoardhelper().boardCounter(), before);
    }
      // 3. Check that Access rights are private when choosing Private access.
    @Test
    public void creatingBoardWithPrivateAccess(){
        app.getBoardhelper().pathToTheCreatingBoardsFormFromBoardButton();
        app.getBoardhelper().createBoardNoTeam("Title3");
        Assert.assertTrue(app.getBoardhelper().isElementPresent(By.cssSelector(".icon-private")));
    }
}
