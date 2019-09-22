package com.trello.qa.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager{
    WebDriver driver;
    TeamHelper teamhelper;
    BoardHelper boardhelper;
    SessionHelper sessionhelper;


    public void init() {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        teamhelper=new TeamHelper(driver);
        boardhelper = new BoardHelper(driver);
        sessionhelper=new SessionHelper(driver);

        sessionhelper.openSite("https://trello.com");
        sessionhelper.login("mskosova.qa@gmail.com","StrangerThings-18");
    }

    public void stop() {
        driver.quit();
    }

    public TeamHelper getTeamhelper() {
        return teamhelper;
    }

    public BoardHelper getBoardhelper() {
        return boardhelper;
    }

    public SessionHelper getSessionhelper() {
        return sessionhelper;
    }
}
