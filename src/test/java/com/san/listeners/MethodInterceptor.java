package com.san.listeners;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> listOfMethods, ITestContext iTestContext) {

        //below list contains all the testng methods that we are going to execute.
        List <IMethodInstance> results =  new ArrayList<IMethodInstance>();

        Map<String, String> test1 = new HashMap<>();
        test1.put("name", "Test1");
        test1.put("count","2");

        Map<String, String> test2 = new HashMap<>();
        test2.put("name", "Test2");
        test2.put("count","3");

        List<Map<String,String>> list = new ArrayList<>();
        list.add(test1);
        list.add(test2);

        for (int i = 0; i < listOfMethods.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if(listOfMethods.get(i).getMethod().getMethodName().equals(list.get(j).get("name"))){
                    listOfMethods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
                    results.add(listOfMethods.get(i));
                }
            }
        }
        return results;
    }
}
