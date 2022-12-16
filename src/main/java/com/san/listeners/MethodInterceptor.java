package com.san.listeners;

import com.san.constants.FrameworkConstants;
import com.san.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> listOfMethods, ITestContext iTestContext) {

        //below list contains all the testng methods that we are going to execute.
        List <IMethodInstance> results =  new ArrayList<>();
        List<Map<String, String>> list = ExcelUtils.getTestData(FrameworkConstants.getRunManagerSheetName());

        for (int i = 0; i < listOfMethods.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if(listOfMethods.get(i).getMethod().getMethodName().equals(list.get(j).get("testname"))) {
                    if(list.get(j).get("execute").equalsIgnoreCase("yes")) {
                        listOfMethods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
                        listOfMethods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
                        listOfMethods.get(i).getMethod().setDescription(list.get(j).get("testdescription"));
                        results.add(listOfMethods.get(i));
                    }
                }
            }
        }
        return results;
    }
}
