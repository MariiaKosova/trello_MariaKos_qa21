package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTest extends TestBase {

    @BeforeMethod
    public void precondetions(){
        app.getBoardhelper().ifThereIsNoBoardCreateOne();
    }

    @Test
    public void renameBoard() throws InterruptedException {
     app.getBoardhelper().chooseFirstBoard();
     String boardTitle = "NewBoard";
     app.getBoardhelper().changeBoardName(boardTitle);
     app.getSessionhelper().goHomePage();
     Assert.assertTrue(app.getBoardhelper().isBoardCreated(boardTitle));
    }
}
