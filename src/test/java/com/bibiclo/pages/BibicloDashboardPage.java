package com.bibiclo.pages;

import com.bibiclo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BibicloDashboardPage {

    public BibicloDashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "expand")
    public WebElement usernameIcon;

    @FindBy(xpath = "//img[@src='/core/img/actions/logout.svg?v=d5694075']")
    public WebElement logoutSelection;


}
