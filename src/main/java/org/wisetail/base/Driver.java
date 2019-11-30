package org.wisetail.base;

import org.wisetail.utils.TargetPlatform;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;


public class Driver {
    private WebDriver webDriver;
    public TargetPlatform currentPlatform;
    private static final int EXPLICIT_WAIT = 180;

    public Driver(TargetPlatform targetPlatform) {
        this.currentPlatform = targetPlatform;
    }

    public void loadBrowserDriver() {
        try {
            Class<?> optionsClass = Class.forName(this.currentPlatform.getBrowserOptions());
            Class<?> driverClass = Class.forName(this.currentPlatform.getBrowserDriver());
            Constructor constructorOptions = optionsClass.getConstructor();
            Constructor constructorDriver = driverClass.getDeclaredConstructor(optionsClass);
            this.webDriver = (WebDriver) constructorDriver.newInstance(constructorOptions.newInstance());
            this.webDriver.manage().timeouts().implicitlyWait(EXPLICIT_WAIT, TimeUnit.SECONDS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    // public static void main(String[] args) {
    //     Driver d = new Driver();
    //     d.init();
    // }
}
