package com.cutanddry.qa.utils;

import com.cutanddry.qa.common.Constants;
import com.cutanddry.qa.utils.aio.core.rest.AioAPIHelper;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.List;

import static com.cutanddry.qa.common.Constants.*;

public class AIOSampleUIMethodListener implements IInvokedMethodListener {

    private boolean isFirstInvocation = CREATE_CYCLE;
    private String newCycleKey;

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

        if (isFirstInvocation) {
            // This block will only run once, before the first test method
            System.out.println("Creating test cycle...");
            // Place your one-time setup code here
            newCycleKey = AioAPIHelper.createCycle(PROJECT_KEY);
            System.out.println("Created cycle name: "+newCycleKey);
            isFirstInvocation = false;
        }

        List<String> caseKeys = AIOUtil.getCaseKeyFromGroupsIfAny(method.getTestMethod().getGroups());
        if(caseKeys != null) {
            if (CREATE_CYCLE){
                caseKeys.forEach(cK -> AioAPIHelper.addCase(PROJECT_KEY, newCycleKey, cK));
            }else {
                caseKeys.forEach(cK -> AioAPIHelper.addCase(PROJECT_KEY, CYCLE_KEY, cK));
            }

        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        List<String> caseKeys = AIOUtil.getCaseKeyFromGroupsIfAny(method.getTestMethod().getGroups());
        if(caseKeys != null) {
            String status = getStatus(testResult.getStatus());
            Long duration = testResult.getEndMillis() - testResult.getStartMillis();
            if (CREATE_CYCLE){
                AioAPIHelper.markCaseStatus(PROJECT_KEY, newCycleKey, caseKeys,
                        (List)testResult.getAttribute("comments"), status, duration);
            }else {
                AioAPIHelper.markCaseStatus(PROJECT_KEY, CYCLE_KEY, caseKeys,
                        (List)testResult.getAttribute("comments"), status, duration);
            }

        }
//        DriverManager.get().quit();
    }

    private String getStatus(Integer i) {
        switch (i) {
            case 1: return "Passed";
            case 2: return "Failed";
            case 3: return "Not Run";
        }
        return "Not Run";
    }

}
