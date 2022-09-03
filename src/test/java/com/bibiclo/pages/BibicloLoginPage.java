package com.bibiclo.pages;

import com.bibiclo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BibicloLoginPage {
    public BibicloLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    @FindBy(id = "lost-password")
    public WebElement ForgotPassword;

    @FindBy(css = "img[src='/core/img/actions/toggle.svg']")
    public WebElement eyeButton;

    @FindBy(xpath = "//p[@class = 'warning wrongPasswordMsg']")
    public WebElement wrongEmailOrUsername;


}
