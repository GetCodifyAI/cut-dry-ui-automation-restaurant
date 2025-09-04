package com.cutanddry.qa.tests.aio;

import com.cutanddry.qa.common.Constants;
import com.cutanddry.qa.utils.aio.core.rest.AioAPIHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateDraftFolderTest {
    
    @Test
    public void testCreateDraftFolderInCases() {
        System.out.println("Testing draft folder creation in Cases...");
        
        System.out.println("Getting folder tree for project: " + Constants.PROJECT_KEY);
        AioAPIHelper.getFolderTree(Constants.PROJECT_KEY);
        
        boolean success = AioAPIHelper.createDraftFolderInCases(Constants.PROJECT_KEY);
        
        System.out.println("Draft folder creation result: " + success);
    }
}
