package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {

    @Test
    public void deleteFirstBoard() throws InterruptedException {
        //goHomePage();
        int before= app.getBoardhelper().boardCounter();
        app.getBoardhelper().chooseAndDeleteFirstBoard();
        app.getBoardhelper().goHomePage();
        Assert.assertEquals(app.getBoardhelper().boardCounter(),before-1);

    }

    @Test
    public void deleteAllBoardExclude3() throws InterruptedException {
        app.getBoardhelper().goHomePage();
        while (app.getBoardhelper().boardCounter()>3){
            deleteFirstBoard();
        }
        Assert.assertEquals(app.getBoardhelper().boardCounter(),3);
    }
}
