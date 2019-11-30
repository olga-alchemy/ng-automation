package org.wisetail.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.List;


public class Page {

    public WebDriver webDriver;
    public Control control;
    //public TargetPlatform currentPlatform;

    public Page(WebDriver webDriver, Control control) {
        this.webDriver = webDriver;
        this.control = control;
    }

    public Page(WebDriver webDriver) {
        this.control = new Control(webDriver);
        this.webDriver = webDriver;
    }

    public void openURL(String url) {
        this.webDriver.get(url);
    }

    public void submitButton(By locator) {
        //WebElement button=this.webDriver.findElement(locator);
        //( (JavascriptExecutor)this.webDriver).executeScript("arguments[0].click();",button);
        this.webDriver.findElement(locator).submit();
    }

    public void doubleClickButton(By locator) {
        if (!control.isButtonClickable(locator)) {
            throw new InvalidElementStateException("button not clickable");
        }
        Actions extendedActions = new Actions(this.webDriver);
        extendedActions.doubleClick(this.webDriver.findElement(locator));
    }

    public String getPageTitle() {
        return this.webDriver.getTitle();
    }

    public String getTextMessage(By locator) {
        return this.webDriver.findElement(locator).getText();
    }//find out what common text can be

    public void editTextBox(By locator, String text) {
        if (!this.control.isTextBoxdEnabled(locator)) {
            throw new InvalidElementStateException("Text box not enabled");
        }
        this.webDriver.findElement(locator).clear();
        this.webDriver.findElement(locator).sendKeys(text);
    }

    public void selectDropDown(By locator, By itemtLocator) {
        WebElement dropDownElement = this.webDriver.findElement(itemtLocator);
        Actions extendedActions = new Actions(this.webDriver);
        this.webDriver.findElement(itemtLocator).click();
        extendedActions.moveToElement(dropDownElement).perform();
        ((JavascriptExecutor) this.webDriver).executeScript("arguments[0].focus();", dropDownElement);
        ((JavascriptExecutor) this.webDriver).executeScript("arguments[0].click();", dropDownElement);
    }
    public void clickButton(By locator) {
        if (control.isButtonClickable(locator)){
            this.webDriver.findElement(locator).click();
        } else {
            throw new ElementNotInteractableException("button not clickable");
        }

    }

    public List<WebElement> getContainerView(By locator) {
        return this.webDriver.findElements(locator);

    }

}
