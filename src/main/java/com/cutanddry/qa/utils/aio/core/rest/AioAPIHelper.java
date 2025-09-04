package com.cutanddry.qa.utils.aio.core.rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import static io.restassured.RestAssured.given;

public class AioAPIHelper {
    private static final String ADD_CASE_TO_CYCLE = "/project/{projectKey}/testcycle/{cycleKey}/testcase/{caseKey}";

    private static final String GET_CYCLE_DETAILS = "/project/{projectKey}/testcycle/{cycleKey}/detail";
    private static final String CREATE_CYCLE = "/project/{projectKey}/testcycle/detail";
    private static final String MARK_CASE = "project/{projectKey}/testcycle/{cycleKey}/testcase/{caseKey}/testrun?createNewRun={createNewRun}";
    private static final String IMPORT_RESULTS = "/project/{projectKey}/testcycle/{cycleKey}/import/results?type={type}";
    private static final String UPLOAD_RUN_ATTACHMENT = "/project/{projectKey}/testcycle/{cycleKey}/testcase/{caseKey}/attachment";
    private static final String GET_FOLDER_TREE = "/project/{projectKey}/testcase/folder";
    private static final String CREATE_FOLDER_HIERARCHY = "/project/{projectKey}/testcase/folder/hierarchy";
    private static RequestSpecification defaultRequestSpec;
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
    private static String todayDate = formatter.format(new Date());

    static  {
        RequestSpecBuilder builder   = new RequestSpecBuilder();
        builder.setBaseUri("https://tcms.aiojiraapps.com");
        builder.setBasePath("/aio-tcms/api/v1");
        builder.addHeader("Authorization", "AioAuth ZGYzMWU0NDItNzllZS0zMzhiLWFiZjYtMTBkYzJlYTE1M2U1LjBjNTRhYTY0LTk0YjctNGZiNy1iZDYwLWYxMWZkOWMzOWViOQ==");
        builder.log(LogDetail.METHOD).log(LogDetail.URI);
        defaultRequestSpec = builder.build();
    }



    private static void importResults(String projectKey, String cycleKey, String fileName, String frameworkType) {
        Map<String, Object> formParams = new HashMap<>();
        formParams.put("createNewRun", true);
        formParams.put("addCaseToCycle", true);
        formParams.put("createCase", true);
        File f = new File(fileName);
        doMultipartPost(IMPORT_RESULTS, f, formParams, projectKey, cycleKey, frameworkType);
    }

    public static void uploadAttachment(String projectKey, String cycleKey, String caseKey, File f) {
        System.out.println("Uploading attachment for " + caseKey);
        doMultipartPost(UPLOAD_RUN_ATTACHMENT, f, null, projectKey, cycleKey, caseKey);
    }

    public static String createCycle(String projectKey, String partValue) {
        Map<String, Object> newCycleDetails = new HashMap<>();
//        newCycleDetails.put("title", "AUTOMATED_EXECUTION_OPERATOR_"+todayDate);
        newCycleDetails.put("title", "AUTOMATED_EXECUTION_OPERATOR_"+ partValue.toUpperCase()+"_"+todayDate);
//        newCycleDetails.put("objective", "Trial Run");
//        Map<String, String> folderDetails = Collections.singletonMap("ID","2");
//        newCycleDetails.put("folder", folderDetails);

        Response response = doPost(CREATE_CYCLE, newCycleDetails, projectKey);
        String newCycleKey = response.jsonPath().getString("key");
        System.out.println("New cycle created " + newCycleKey);
        return newCycleKey;
    }

    private static void markCaseStatus(String projectKey, String cycleKey, List<String> caseKeys) {
        Map<String, Object> runStatus = new HashMap<>();
        runStatus.put("testRunStatus", "Passed");
        runStatus.put("effort", "60000");
        for(String caseKey : caseKeys) {
            doPost(MARK_CASE, runStatus, projectKey, cycleKey, caseKey, "true" );
        }
    }

    public static void markCaseStatus(String projectKey, String cycleKey, List<String> caseKeys, List<String> comments,
                                      String status, Long duration ) {
        Map<String, Object> runStatus = new HashMap<>();
        runStatus.put("testRunStatus", status);
        runStatus.put("effort", duration.toString());
        runStatus.put("comments",comments);
        for(String caseKey : caseKeys) {
            doPost(MARK_CASE, runStatus, projectKey, cycleKey, caseKey, "false" );
        }
    }
    public static String addCase(String projectKey, String cycleKey, String caseKey) {
        Response r = doPost(ADD_CASE_TO_CYCLE, null, projectKey, cycleKey, caseKey);
        // Check if response is in JSON format and contains the expected data
        String responseBody = r.getBody().asString();
        try {
            if (r.getContentType().contains("application/json")) {
                String id = r.jsonPath().getString("ID");
                System.out.println("Case ID retrieved: " + id);
                return id;
            } else {
                System.err.println("Unexpected response format. Response: " + responseBody);
            }
        } catch (JsonPathException e) {
            System.err.println("Failed to parse JSON. Response was: " + responseBody);
        }
        return null;
    }

    public static Response getFolderTree(String projectKey) {
        Response response = given(defaultRequestSpec)
                .when().get(GET_FOLDER_TREE, projectKey).andReturn();
        System.out.println("Folder tree response status: " + response.statusCode());
        if (response.statusCode() == 200) {
            String responseBody = response.getBody().asString();
            System.out.println("FOLDER_TREE_JSON_START");
            System.out.println(responseBody);
            System.out.println("FOLDER_TREE_JSON_END");
        } else {
            System.err.println("Failed to get folder tree. Status Code: " + response.statusCode());
            response.prettyPrint();
        }
        return response;
    }

    public static String createFolderHierarchy(String projectKey, int baseFolderId, String[] folderHierarchy) {
        Map<String, Object> folderData = new HashMap<>();
        folderData.put("baseFolderId", baseFolderId);
        folderData.put("folderHierarchy", folderHierarchy);
        
        Response response = given(defaultRequestSpec)
                .contentType(ContentType.JSON)
                .body(folderData)
                .when().put(CREATE_FOLDER_HIERARCHY, projectKey).andReturn();
                
        System.out.println("Folder creation response status: " + response.statusCode());
        if (response.statusCode() == 200) {
            System.out.println("Folder hierarchy created successfully");
            return response.getBody().asString();
        } else {
            System.err.println("Failed to create folder hierarchy. Status Code: " + response.statusCode());
            response.prettyPrint();
            return null;
        }
    }

    public static boolean createDraftFolderInCases(String projectKey) {
        try {
            Response folderTreeResponse = getFolderTree(projectKey);
            if (folderTreeResponse.statusCode() != 200) {
                System.err.println("Failed to get folder tree");
                return false;
            }
            
            String responseBody = folderTreeResponse.getBody().asString();
            int notAssignedFolderId = findNotAssignedFolderId(responseBody);
            
            if (notAssignedFolderId == -1) {
                System.out.println("'Not assigned' folder not found. Attempting to create it first...");
                
                String[] rootFolderIds = {"55", "56", "135"}; // DP Features, GA Features, Synthetic Monitoring
                boolean notAssignedCreated = false;
                
                for (String rootId : rootFolderIds) {
                    try {
                        String[] notAssignedHierarchy = {"Not assigned"};
                        String result = createFolderHierarchy(projectKey, Integer.parseInt(rootId), notAssignedHierarchy);
                        if (result != null) {
                            System.out.println("Successfully created 'Not assigned' folder under root folder ID: " + rootId);
                            folderTreeResponse = getFolderTree(projectKey);
                            responseBody = folderTreeResponse.getBody().asString();
                            notAssignedFolderId = findNotAssignedFolderId(responseBody);
                            notAssignedCreated = true;
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Failed to create 'Not assigned' under root ID " + rootId + ": " + e.getMessage());
                    }
                }
                
                if (!notAssignedCreated) {
                    System.err.println("Could not create 'Not assigned' folder");
                    return false;
                }
            }
            
            if (notAssignedFolderId == -1) {
                System.err.println("Still could not find 'Not assigned' folder after creation attempt");
                return false;
            }
            
            System.out.println("Creating 'draft' folder under 'Not assigned' folder (ID: " + notAssignedFolderId + ")...");
            String[] draftHierarchy = {"draft"};
            String result = createFolderHierarchy(projectKey, notAssignedFolderId, draftHierarchy);
            
            if (result != null) {
                System.out.println("Successfully created 'draft' folder under 'Not assigned'");
                return true;
            } else {
                System.err.println("Failed to create 'draft' folder under 'Not assigned'");
                return false;
            }
            
        } catch (Exception e) {
            System.err.println("Error creating draft folder: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static boolean createTestFolderInNotAssigned(String projectKey) {
        try {
            Response folderTreeResponse = getFolderTree(projectKey);
            if (folderTreeResponse.statusCode() != 200) {
                System.err.println("Failed to get folder tree");
                return false;
            }
            
            String responseBody = folderTreeResponse.getBody().asString();
            int notAssignedFolderId = findNotAssignedFolderId(responseBody);
            
            if (notAssignedFolderId == -1) {
                System.err.println("Could not find 'Not assigned' folder");
                return false;
            }
            
            System.out.println("Creating 'test' folder under 'Not assigned' folder (ID: " + notAssignedFolderId + ")...");
            String[] testHierarchy = {"test"};
            String result = createFolderHierarchy(projectKey, notAssignedFolderId, testHierarchy);
            
            if (result != null) {
                System.out.println("Successfully created 'test' folder under 'Not assigned'");
                return true;
            } else {
                System.err.println("Failed to create 'test' folder under 'Not assigned'");
                return false;
            }
            
        } catch (Exception e) {
            System.err.println("Error creating test folder: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    private static int findNotAssignedFolderId(String folderTreeJson) {
        try {
            if (folderTreeJson.contains("\"name\":\"Not assigned\"")) {
                String[] parts = folderTreeJson.split("\"name\":\"Not assigned\"");
                if (parts.length > 1) {
                    String beforeNotAssigned = parts[0];
                    String[] idParts = beforeNotAssigned.split("\"ID\":");
                    if (idParts.length > 0) {
                        String lastIdPart = idParts[idParts.length - 1];
                        String idStr = lastIdPart.split(",")[0].trim();
                        System.out.println("Found 'Not assigned' folder ID: " + idStr);
                        return Integer.parseInt(idStr);
                    }
                }
            }
            
            String[] variations = {"\"name\":\"Not Assigned\"", "\"name\":\"not assigned\"", "\"name\":\"Unassigned\"", "\"name\":\"unassigned\""};
            for (String variation : variations) {
                if (folderTreeJson.contains(variation)) {
                    String[] parts = folderTreeJson.split(variation);
                    if (parts.length > 1) {
                        String beforeFolder = parts[0];
                        String[] idParts = beforeFolder.split("\"ID\":");
                        if (idParts.length > 0) {
                            String lastIdPart = idParts[idParts.length - 1];
                            String idStr = lastIdPart.split(",")[0].trim();
                            System.out.println("Found folder with variation '" + variation + "', ID: " + idStr);
                            return Integer.parseInt(idStr);
                        }
                    }
                }
            }
            
            System.out.println("Could not find 'Not assigned' folder in folder tree");
            return -1;
        } catch (Exception e) {
            System.err.println("Error parsing folder tree JSON for 'Not assigned': " + e.getMessage());
            return -1;
        }
    }


    public static Response doPost(String path, Map<String, Object> params, Object... pathParams) {
        Response response = params != null ?
                given(defaultRequestSpec).contentType(ContentType.JSON).body(params).when().post(path, pathParams).andReturn() :
                given(defaultRequestSpec).contentType(ContentType.JSON).when().post(path, pathParams).andReturn();
        // Log the response status code and content type
        System.out.println("Response Status Code: " + response.statusCode());
        System.out.println("Response Content Type: " + response.getContentType());
        if (response.statusCode() == 200) {
            System.out.println("Case posted successfully in : " + pathParams[0]);
        } else {
            System.err.println("Failed to post case. Status Code: " + response.statusCode());
            response.prettyPrint();
        }
        return response;
    }

//    public static String addCase(String projectKey, String cycleKey, String caseKey ) {
//        Response r =  doPost(ADD_CASE_TO_CYCLE, null, projectKey, cycleKey, caseKey );
//        return r.jsonPath().get("ID").toString();
//    }
//
//    public static Response doGet(String path, String ...pathParams) {
//        Response response = given(defaultRequestSpec).when().get(path,pathParams).andReturn();
//        response.prettyPrint();
//        return response;
//    }
//
//    public static Response doPost(String path, Map<String, Object> params, Object ...pathParams) {
//        Response response = params != null?
//                given(defaultRequestSpec).contentType(ContentType.JSON).body(params).when().post(path,pathParams).andReturn() :
//                given(defaultRequestSpec).contentType(ContentType.JSON).when().post(path,pathParams).andReturn();
//        if(response.statusCode() == 200) {
//            System.out.println("Case posted successfully in : " + pathParams[0]);
//        } else {
//            response.prettyPrint();
//        }
//        return response;
//    }

    public static Response doMultipartPost(String path, File file, Map<String, Object> formParams, Object ...pathParams) {

        Response response = formParams == null?
                given(defaultRequestSpec)
                        .multiPart("file",file,"image/png").when().post(path,pathParams).andReturn():
                given(defaultRequestSpec).multiPart("file", file.getAbsoluteFile()).formParams(formParams).when().post(path,pathParams).andReturn();
        response.prettyPrint();
        return response;
    }



    private enum STATUS_MAP {
        PASS("Passed"), FAIL("Failed"), SKIP("Not Run");
        String aioMappingStatus;

        STATUS_MAP(String aioMappingStatus) {
            this.aioMappingStatus = aioMappingStatus;
        }

        public String getAioMappingStatus() {
            return aioMappingStatus;
        }

    }
}
