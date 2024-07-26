package com.cutanddry.qa.common;

public class Constants {
    public static String BROWSER_NAME = System.getProperty("test.browser", "chrome");
    public static boolean RUN_HEADLESS = Boolean.parseBoolean(System.getProperty("run.headless", "true"));
    public static String TEST_ENV = System.getProperty("test.env", "uat");
    public static String MAIN_URL = baseDomain();

    private static String baseDomain() {
        if (TEST_ENV.equalsIgnoreCase("UAT")){
            MAIN_URL = "https://supplier-"+TEST_ENV+".staging.cutanddry.com/";
        } else if (TEST_ENV.equalsIgnoreCase("")){
            //implement for other env here
        }
        return MAIN_URL;
    }

}
