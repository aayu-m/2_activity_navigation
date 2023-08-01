package com.example.a1_navigation_activity;

public class Application {
    private String appName;
    private String appDeveloper;
    private String appDescription;
    private String logoLink;

    public Application(String appName, String appDeveloper, String appDescription, String logoLink){
        this.appName = appName;
        this.appDeveloper = appDeveloper;
        this.appDescription = appDescription;
        this.logoLink = logoLink;

    }

    public String getAppName() {
        return appName;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public String getAppDeveloper() {
        return appDeveloper;
    }
    public String getLogoLink() { return logoLink;}
}
