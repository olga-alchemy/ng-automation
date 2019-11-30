package org.wisetail.pages;

import org.wisetail.base.Page;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.wisetail.utils.LoginPageLanguage;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

public class LoginPage extends Page {
    public static final int IMPLICIT_WAIT = 60;
    public static final int EXPLICIT_WAIT = 30;
    public static final String pageTitle="Home";
    private final Logger logger=Logger.getLogger(LoginPage.class);

    By loginNameLocator = By.name("username");
    By loginPasswordLocator = By.name("password");
    By loginButtonLocator = By.xpath("//button[@type='submit']");
    By loginErrorLocator = By.className("md-input-message-animation");
    By loginLangLocator = By.id("select_2");
    By selectEnglish = By.id("select_option_4");
    By selectEnglishCanada = By.id("select_option_5");
    By selectFrench = By.id("select_option_6");
    By postLoginLangLocator = By.id("select_23");
    By selectPostLoginSpanish = By.id("select_option_26");
    By selectPostLoginEnglish = By.id("select_option_25");
    By postLoginButtonLocator = By.id("//button[@type='submit']");
    By HomePageLocator = By.xpath("//*[@id=\"leftnavbar\"]/md-content/md-list/md-list-item[1]/div[1]/i");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void navigateTo(String location) {
        if (location.startsWith("https")) {
            super.openURL(location);
            super.webDriver.manage().timeouts().pageLoadTimeout(IMPLICIT_WAIT, TimeUnit.SECONDS);
        } else if (location.startsWith("Home")){
            super.clickButton(HomePageLocator);
        }
    }

    public void logIn(String userName, String userPassword) {
        Assertions.assertTrue(super.control.isTextBoxdEnabled(loginNameLocator));
        super.editTextBox(loginNameLocator, userName);
        Assertions.assertTrue(super.control.isTextBoxdEnabled(loginPasswordLocator));
        super.editTextBox(loginPasswordLocator, userPassword);
        Assertions.assertTrue(super.control.isButtonClickable(loginButtonLocator), "LogIn button not enabled, locator " + loginButtonLocator.toString());
        super.submitButton(loginButtonLocator);
        super.webDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        //Assertions.assertTrue(super.getPageTitle().contains(pageTitle), "Current page title" + super.getPageTitle());
    }

    public void loginLanguageSelect(LoginPageLanguage language) {
        if (language.equals(LoginPageLanguage.FRENCH)) {
            super.selectDropDown(loginLangLocator, selectFrench);
        } else if (language.equals(LoginPageLanguage.ENGLISH)) {
            super.selectDropDown(loginLangLocator, selectEnglish);
        } else if (language.equals(LoginPageLanguage.ENGLISH_CA)) {
            super.selectDropDown(loginLangLocator, selectEnglishCanada);
        } else {
            throw new NotFoundException("language not supported" + language.getDropDownSelection());
        }
    }
    public void postLoginLanguageSelect(LoginPageLanguage language){
        if (language.equals(LoginPageLanguage.ENGLISH)){
            super.selectDropDown(postLoginLangLocator,selectPostLoginEnglish );
        } else if (language.equals(LoginPageLanguage.SPANISH)){
            super.selectDropDown(postLoginLangLocator,selectPostLoginSpanish);
        } else {
            throw new NotFoundException("language not supported" + language.getDropDownSelection());
        }
        if (super.control.isButtonClickable(postLoginButtonLocator)){
            super.submitButton(postLoginButtonLocator);
        } else {
            throw new ElementNotInteractableException("button not enabled");
        }
    }

    public String loginError() {
        return super.getTextMessage(loginErrorLocator);
    }
}
