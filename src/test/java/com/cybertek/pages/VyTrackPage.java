package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackPage {
    public VyTrackPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="prependedInput")
        public WebElement userNameField;

    @FindBy(id ="prependedInput2")
    public WebElement passwordField;


    @FindBy(id = "_submit")
    public WebElement loginBtn;

    @FindBy(id = "user-menu")
    public WebElement userMenu;

    @FindBy(linkText = "Logout")
    public WebElement logOut;


    public void login(String userName, String password) {

        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginBtn.click();
    }
}
