package org.wisetail.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Control {
    WebDriver webDriver;
    Page page;

    public Control(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean isButtonClickable(By locator) {

        try {
            WebElement webElement = webDriver.findElement(locator);
            if (webElement.isEnabled() && webElement.getSize().height > 0 && webElement.getSize().width > 0) {
                return true;
            }

        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean isTextBoxdEnabled(By locator) {

        try {
            WebElement webElement = webDriver.findElement(locator);
            if (webElement.isEnabled()) {
                return true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

}
