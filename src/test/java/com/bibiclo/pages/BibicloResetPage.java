package com.bibiclo.pages;

import com.bibiclo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BibicloResetPage {
    public BibicloResetPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "reset-password-submit")
    public WebElement resetPasswordButton;

}
