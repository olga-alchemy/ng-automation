package org.wisetail;

import org.wisetail.pages.LoginPage;
import org.wisetail.utils.LoginPageLanguage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class loginTest extends BaseTest {
    public static final String PASSWORD_ERROR_MESSAGE = "Password is required.";
    public static final String landingPage = BaseTest.customProperties.getProperty("loginURL");
    public static String extFile = BaseTest.customProperties.getProperty("tenant");
    public LoginPage loginPage = new LoginPage(webDriver);

    @BeforeEach
    @DisplayName("Display Landing Page")
    public void testSETUP() {
        loginPage.navigateTo(landingPage);
    }

    @ParameterizedTest
    @DisplayName("En-CA language user singIn with default language")
    @Tag("singleTest")
    @CsvFileSource(resources = "/LoginTestData.csv", numLinesToSkip = 1)
    public void loginValidUsernameValidPassword(String userName, String userPassword) {
        loginPage.logIn(userName, userPassword);
        Assertions.assertTrue(loginPage.getPageTitle().contains("Link"));
    }

    @Test
    @DisplayName("En-CA language user singIn with default language")
    public void loginBlankUsernameBlankPassword() {
        loginPage.logIn("  ", "  ");
        Assertions.assertTrue(loginPage.loginError().contains(PASSWORD_ERROR_MESSAGE));
    }

    @ParameterizedTest
    @DisplayName("ItemsView French language, english-ca user")
    @CsvFileSource(resources = "/LoginTestData.csv", numLinesToSkip = 1)
    public void selectFrenchEnglishCAuser() {
        loginPage.loginLanguageSelect(LoginPageLanguage.FRENCH);
        loginPage.logIn("ats_user02", "frame1234!!");
        Assertions.assertTrue(loginPage.getPageTitle().equalsIgnoreCase("newsfeed"));
    }
}
