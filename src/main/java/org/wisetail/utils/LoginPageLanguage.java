package org.wisetail.utils;

import java.util.ArrayList;

public enum LoginPageLanguage {
    ENGLISH("English", "Forgot your password?", "Privacy Policy", "Terms of Service", "english"),
    ENGLISH_CA("English (Canada)", "", "", "", ""),
    FRENCH("Français (Canada)", "", "", "", "entrer"),
    SPANISH("Español (Estados Unidos/Latinoamérica)", "", "", "", "entrer");


    private String dropDownSelection;
    private String forgotPassword;
    private String privacyPolicy;
    private String termsOfService;
    private String buttonText;

    public String getDropDownSelection() {
        return dropDownSelection;
    }

    public String getForgotPassword() {
        return forgotPassword;
    }

    public String getPrivacyPolicy() {
        return privacyPolicy;
    }

    public String getTermsOfService() {
        return termsOfService;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setDropDownSelection(String dropDownSelection) {
        this.dropDownSelection = dropDownSelection;
    }

    public void setForgotPassword(String forgotPassword) {
        this.forgotPassword = forgotPassword;
    }

    public void setPrivacyPolicy(String privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }

    public void setTermsOfService(String termsOfService) {
        this.termsOfService = termsOfService;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    LoginPageLanguage(String languageSelection, String forgotPassword, String privacyPolicy, String termsOfService, String buttonText) {
        this.dropDownSelection = languageSelection;
        this.forgotPassword = forgotPassword;
        this.privacyPolicy = privacyPolicy;
        this.termsOfService = termsOfService;
        this.buttonText = buttonText;
    }
}
