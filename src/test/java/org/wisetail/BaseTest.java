package org.wisetail;

import org.wisetail.pages.LoginPage;
import org.wisetail.utils.CustomProperties;
import org.wisetail.utils.TargetPlatform;
import org.wisetail.utils.TargetPlatformMethods;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.wisetail.base.Driver;

abstract class BaseTest {
    public static WebDriver webDriver;
    public static TargetPlatformMethods targetPlatformMethods;
    public static TargetPlatform targetPlatform;
    public static CustomProperties customProperties;
    public static LoginPage loginPage;
    public static String tenant;

    @BeforeAll
    public static void init() {
        customProperties = new CustomProperties();
        customProperties.loadCustomPropertiesFromFile();
        targetPlatformMethods = new TargetPlatformMethods();
        String browserName = customProperties.getProperty("browser", "chrome");
        String landingPage = customProperties.getProperty("loginURL");
        //tenant=customProperties.getProperty("tenant");

        targetPlatform = targetPlatformMethods.getTargetPlatform(browserName);
        //set target platform within driver
        Driver driver = new Driver(targetPlatform);
        //load driver
        driver.loadBrowserDriver();
        webDriver = driver.getWebDriver();
        loginPage = new LoginPage(webDriver);
        loginPage.navigateTo(landingPage);

    }

    @AfterAll
    public static void clean() {
        webDriver.manage().deleteAllCookies();
        webDriver.close();
    }
}
