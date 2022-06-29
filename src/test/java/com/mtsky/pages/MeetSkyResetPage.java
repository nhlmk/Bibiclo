package com.mtsky.pages;

import com.mtsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MeetSkyResetPage {
    public MeetSkyResetPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "reset-password-submit")
    public WebElement resetPasswordButton;

}
