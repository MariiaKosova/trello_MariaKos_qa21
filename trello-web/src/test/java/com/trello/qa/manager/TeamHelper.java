package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HalperBase {

    public TeamHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnPlusButtonTeams() {
        click(By.cssSelector(".icon-add.icon-sm"));
    }

    public void fillTeamCreationForm(String teamName, String description) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        type(By.cssSelector("textarea"), description);
    }

    public void clickTeamContinueButton() {
        click(By.cssSelector("[type=submit]"));
    }
}
