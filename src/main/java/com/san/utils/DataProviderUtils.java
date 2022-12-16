package com.san.utils;

import com.san.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {

    private static List<Map<String, String>> list = new ArrayList<>();

    @DataProvider(parallel = true)
    public static Object[] getData(){

        if(list.isEmpty()) // to avoid making connection to excel for every test method execution.
            list = ExcelUtils.getTestData(FrameworkConstants.getLoginDataSheetName());

        return list.toArray();
    }

}
