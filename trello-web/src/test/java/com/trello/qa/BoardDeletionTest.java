package com.trello.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {

    @Test
    public void deleteFirstBoard() throws InterruptedException {
        //goHomePage();
        int before= app.boardCounter();
        app.chooseAndDeleteFirstBoard();
        app.goHomePage();
        Assert.assertEquals(app.boardCounter(),before-1);

    }

    @Test
    public void deleteAllBoardExclude3() throws InterruptedException {
        app.goHomePage();
        while (app.boardCounter()>3){
            deleteFirstBoard();
        }
        Assert.assertEquals(app.boardCounter(),3);
    }
}
