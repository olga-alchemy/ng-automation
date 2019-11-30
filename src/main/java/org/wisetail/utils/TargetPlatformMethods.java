package org.wisetail.utils;

public class TargetPlatformMethods {
    TargetPlatform currentTargetPlatform;

    public TargetPlatformMethods() {
    }

    public TargetPlatform getTargetPlatform(String browserName) {
        if (browserName == null || browserName.isEmpty()) {
            System.out.println("browser name was not provided " + TargetPlatform.SAFARI.getBrowserName());
            return TargetPlatform.SAFARI;
        }
        TargetPlatform[] platformItems = TargetPlatform.values();
        for (TargetPlatform platformItem : platformItems) {
            if (browserName.equalsIgnoreCase(platformItem.getBrowserName())) {
                return platformItem;
            }
        }
        return TargetPlatform.CHROME;
    }
}
