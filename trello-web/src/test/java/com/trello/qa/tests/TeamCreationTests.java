package com.trello.qa.tests;

import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @Test
    public void testTeamCreation() throws InterruptedException {
        app.getSessionhelper().goHomePage();
        app.getTeamhelper().clickOnPlusButtonTeams();
        String teamName = "MyTeam";
        app.getTeamhelper().fillTeamCreationForm(teamName, "My perfect team");
        app.getTeamhelper().clickTeamContinueButton();
        app.getSessionhelper().goHomePage();
    }
}
