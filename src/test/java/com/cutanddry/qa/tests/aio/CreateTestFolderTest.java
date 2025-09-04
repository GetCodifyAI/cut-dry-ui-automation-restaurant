package com.cutanddry.qa.tests.aio;

import com.cutanddry.qa.common.Constants;
import com.cutanddry.qa.utils.aio.core.rest.AioAPIHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateTestFolderTest {
    
    @Test
    public void testCreateTestFolderInNotAssigned() {
        System.out.println("Testing test folder creation under 'Not assigned'...");
        
        System.out.println("Getting folder tree for project: " + Constants.PROJECT_KEY);
        AioAPIHelper.getFolderTree(Constants.PROJECT_KEY);
        
        boolean success = AioAPIHelper.createTestFolderInNotAssigned(Constants.PROJECT_KEY);
        
        System.out.println("Test folder creation result: " + success);
        Assert.assertTrue(success, "Failed to create test folder under 'Not assigned'");
    }
}
