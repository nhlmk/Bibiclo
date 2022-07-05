package com.mtsky.pages;

import com.mtsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MeetSkyDashboardPage {

    public MeetSkyDashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "expand")
    public WebElement usernameIcon;

    @FindBy(xpath = "//img[@src='/core/img/actions/logout.svg?v=d5694075']")
    public WebElement logoutSelection;


}
