package org.wisetail.utils;

public enum TargetPlatform {

    CHROME("chrome", "org.openqa.selenium.chrome.ChromeOptions", "org.openqa.selenium.chrome.ChromeDriver"),
    SAFARI("safari", "org.openqa.selenium.safari.SafariOptions", "org.openqa.selenium.safari.SafariDriver"),
    ALL("safari", "", ""),
    ANDROID("safari", "", ""),
    iOS("safari", "", ""),
    WINDOWS("chrome", "org.openqa.selenium.chrome.ChromeOptions", "org.openqa.selenium.chrome.ChromeDriver");

    TargetPlatform(String browserName) {
        this.browserName = browserName;
    }
    private String browserName;
    private String browserOptions;
    private String browserDriver;

    TargetPlatform() {

    }
    public String getBrowserName() {
        return browserName;
    }

    TargetPlatform(String browserName, String browserOptions, String briowserDriver) {
        this.browserName = browserName;
        this.browserOptions = browserOptions;
        this.browserDriver = briowserDriver;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserOptions() {
        return this.browserOptions;
    }

    public String getBrowserDriver() {
        return this.browserDriver;
    }

}
