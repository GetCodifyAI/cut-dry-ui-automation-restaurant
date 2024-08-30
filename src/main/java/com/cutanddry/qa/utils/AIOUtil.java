package com.cutanddry.qa.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.cutanddry.qa.common.Constants.PROJECT_KEY;

public class AIOUtil {
    public static List<String> getCaseKeyFromGroupsIfAny(String[] groups) {
        if (groups != null) {
            return Arrays.stream(groups).filter(group -> group.trim().startsWith(PROJECT_KEY + "-TC-")).map(g -> g.trim())
                    .collect(Collectors.toList());
        }
        return null;

    }
}
