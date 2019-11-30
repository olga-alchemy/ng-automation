package org.wisetail.pages;
import org.wisetail.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends Page {
    public List<WebElement> overallCourseCompletion;
    By overallCourseCompletionLocator = By.xpath("//*/fw-home-overall-course-completion");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.overallCourseCompletion = new ArrayList<>();
        this.overallCourseCompletion = super.getContainerView(overallCourseCompletionLocator);
    }
    public long getOverallCourseCompletionCount() {
        long count=0;
        if (!this.overallCourseCompletion.isEmpty()) {
            count=overallCourseCompletion.stream().filter(item -> item.isDisplayed()).count();
        }
        return count;
    }
    public List<String>courseCompletionTextMessage() {
        if (!this.overallCourseCompletion.isEmpty()) {
            return overallCourseCompletion.stream().map(WebElement::getText).collect(Collectors.toList());
        }
        else return Collections.emptyList();
    }
}
