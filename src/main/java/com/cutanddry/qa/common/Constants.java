package com.cutanddry.qa.common;

public class Constants {
    public final static String PROJECT_KEY = System.getProperty("project.key","DOT");
    public final static String CYCLE_KEY = System.getProperty("cycle.key","DOT-CY-");
    public static boolean CREATE_CYCLE = Boolean.parseBoolean(System.getProperty("create.cycle","false"));
    public static String BROWSER_NAME = System.getProperty("test.browser", "chrome");
    public static boolean RUN_HEADLESS = Boolean.parseBoolean(System.getProperty("run.headless", "false"));
    public static String TEST_ENV = System.getProperty("test.env", "uat");
    public static String SLACK_TOKEN = System.getProperty("slack.token", "***");
    public static String SLACK_CHANNEL = System.getProperty("slack.channel", "#ui-automation-tests");
    public static String MAIN_URL = baseDomain();
    public static String SEC_URL = secDomain();
    public static String WHITELABEL_APP_URL = "https://sutters-uat.staging.cutanddry.com/";
    public static String LOGIN_AS_APP_URL = "https://app-uat.staging.cutanddry.com/internaltools/loginas";

    public static String SLACK_WEBHOOK = System.getenv("SLACK_WEBHOOK");

    //slackToken=***
    //slackChannel=#ui-automation-tests

    private static String baseDomain() {
        if (TEST_ENV.equalsIgnoreCase("UAT")){
            MAIN_URL = "https://app-uat.staging.cutanddry.com/";
        } else if (TEST_ENV.equalsIgnoreCase("PROD")){
            MAIN_URL = "https://app.cutanddry.com/";
        }
        return MAIN_URL;
    }

    private static String secDomain() {
        if (TEST_ENV.equalsIgnoreCase("UAT")){
            SEC_URL = "https://supplier-"+TEST_ENV+".staging.cutanddry.com/";
        } else if (TEST_ENV.equalsIgnoreCase("")){
            //implement for other env here
        }
        return SEC_URL;
    }

}
