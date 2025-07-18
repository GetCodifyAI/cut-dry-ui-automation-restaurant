package com.cutanddry.qa.common;

public class Constants {
    public final static String PROJECT_KEY = System.getProperty("project.key","DOT");
    public final static String CYCLE_KEY = System.getProperty("cycle.key","DOT-CY-");
    public static boolean CREATE_CYCLE = Boolean.parseBoolean(System.getProperty("create.cycle","false"));
    public static String BROWSER_NAME = System.getProperty("test.browser", "chrome");
    public static boolean RUN_HEADLESS = Boolean.parseBoolean(System.getProperty("run.headless", "false"));
    public static String TEST_ENV = System.getProperty("test.env", "stag");
    public static String SLACK_TOKEN = System.getProperty("slack.token", "***");
    public static String SLACK_CHANNEL = System.getProperty("slack.channel", "#ui-automation-tests");
    public static String MAIN_URL = baseDomain();
    public static String SEC_URL = secDomain();
    public static String WHITELABEL_APP_URL = whiteLableAppURL();
    public static String LOGIN_AS_APP_URL = loginAsDomain();
    public static String GATE_KEEPER_URL =gateKeeperURL();
    public static String SLACK_WEBHOOK = System.getenv("STAGING_SLACK_WEBHOOK");
    public static String PUBLIC_PAY_URL = "https://app-uat.staging.cutanddry.com/public-pay/";
    public static String SAVAL_FOOD_URL = "https://savalfoodservice-uat.staging.cutanddry.com/log-in?redirect_on_login=%2F";
    public static final String TEST_STAG ="ish-defuom";


    //slackToken=***
    //slackChannel=#ui-automation-tests

    private static String baseDomain() {
        if (TEST_ENV.equalsIgnoreCase("UAT")){
            MAIN_URL = "https://app-uat.staging.cutanddry.com/";
        } else if (TEST_ENV.equalsIgnoreCase("PROD")){
            MAIN_URL = "https://app.cutanddry.com/";
        } else if (TEST_ENV.equalsIgnoreCase("STAG_1")) {
            MAIN_URL = "https://app-guava.staging.cutanddry.com/";
        }
        else if (TEST_ENV.equalsIgnoreCase("STAG")) {
            MAIN_URL = "https://app-"+TEST_STAG+".staging.cutanddry.com/";
        }
        return MAIN_URL;
    }

    private static String secDomain() {
        if (TEST_ENV.equalsIgnoreCase("UAT")){
            SEC_URL = "https://supplier-"+TEST_ENV+".staging.cutanddry.com/";
        } else if (TEST_ENV.equalsIgnoreCase("")){
            //implement for other env here
        }else if (TEST_ENV.equalsIgnoreCase("STAG_1")){
            SEC_URL = "https://supplier-guava.staging.cutanddry.com/";
        }
        else if (TEST_ENV.equalsIgnoreCase("STAG")){
            SEC_URL = "https://supplier-"+TEST_STAG+".staging.cutanddry.com/";
        }
        return SEC_URL;
    }

    private static String loginAsDomain() {
        if (TEST_ENV.equalsIgnoreCase("UAT")) {
            LOGIN_AS_APP_URL = "https://app-uat.staging.cutanddry.com/internaltools/loginas";
        } else if (TEST_ENV.equalsIgnoreCase("PROD")) {
            LOGIN_AS_APP_URL = "https://app.cutanddry.com/internaltools/loginas";
        } else if (TEST_ENV.equalsIgnoreCase("STAG_1")) {
            LOGIN_AS_APP_URL = "https://app-guava.staging.cutanddry.com/internaltools/loginas";
        }
        else if (TEST_ENV.equalsIgnoreCase("STAG")) {
            LOGIN_AS_APP_URL = "https://app-"+TEST_STAG+".staging.cutanddry.com/internaltools/loginas";
        }
        return LOGIN_AS_APP_URL;
    }

    private static String gateKeeperURL() {
        if (TEST_ENV.equalsIgnoreCase("UAT")) {
            GATE_KEEPER_URL = "https://app-uat.staging.cutanddry.com/gatekeeperadmin";
        } else if (TEST_ENV.equalsIgnoreCase("PROD")) {
            GATE_KEEPER_URL = "https://app.cutanddry.com/gatekeeperadmin";
        } else if (TEST_ENV.equalsIgnoreCase("STAG_1")) {
            GATE_KEEPER_URL = "https://app-guava.staging.cutanddry.com/gatekeeperadmin";
        }
        else if (TEST_ENV.equalsIgnoreCase("STAG")) {
            GATE_KEEPER_URL = "https://app-"+TEST_STAG+".staging.cutanddry.com/gatekeeperadmin";
        }
        return GATE_KEEPER_URL;
    }

    private static String whiteLableAppURL() {
        if (TEST_ENV.equalsIgnoreCase("UAT")) {
            WHITELABEL_APP_URL = "https://sutters-uat.staging.cutanddry.com/";
        } else if (TEST_ENV.equalsIgnoreCase("PROD")) {
            WHITELABEL_APP_URL = "https://sutters-uat.staging.cutanddry.com/";
        } else if (TEST_ENV.equalsIgnoreCase("STAG_1")) {
            WHITELABEL_APP_URL = "https://sutters-guava.staging.cutanddry.com/";
        }
        else if (TEST_ENV.equalsIgnoreCase("STAG")) {
            WHITELABEL_APP_URL = "https://sutters-"+TEST_STAG+".staging.cutanddry.com/";
        }
        return WHITELABEL_APP_URL;
    }

}
