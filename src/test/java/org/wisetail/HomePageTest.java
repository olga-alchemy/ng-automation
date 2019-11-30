package org.wisetail;

import org.wisetail.pages.HomePage;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.wisetail.utils.LoginPageLanguage;

public class HomePageTest extends BaseTest{
    HomePage homePage = new HomePage(webDriver);

    @Order(1)
    @DisplayName("Display Home Page")
    @ParameterizedTest
    @CsvFileSource(resources = "/HomeTestData.csv", numLinesToSkip = 1)
    public void testSETUP(String userName, String userPassword) {
        loginPage.logIn(userName,userPassword);
        loginPage.postLoginLanguageSelect(LoginPageLanguage.ENGLISH_CA);
        //Assertions.assertTrue(homePage.getPageTitle().contains("Home"));
    }
    @DisplayName("Overal Completion Cards Count")
    @Test
    public void homePageVerifyOverallCourseCompletionCounts() {
        Assertions.assertTrue(homePage.getOverallCourseCompletionCount() > 0);
    }
    @Test
    @ParameterizedTest
    @CsvFileSource(resources = "/OverallTestCompletionData.csv", numLinesToSkip = 1)
    public void homePageVerifyOverallCourseCompletionText(String overallTestCompletionText) {
        Assertions.assertTrue(homePage.courseCompletionTextMessage().contains(overallTestCompletionText));
    }
}
