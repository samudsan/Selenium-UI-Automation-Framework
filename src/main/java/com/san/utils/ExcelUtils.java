package com.san.utils;

import com.san.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtils {
    private ExcelUtils() {}

    public static List<Map<String, String>> getTestData(String sheetName){
        List<Map<String, String>> list;

        // below is try with resources, supported from java 1.8
        try(FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath())) {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int row = sheet.getLastRowNum();
            int lastColumn = sheet.getRow(0).getLastCellNum();

            Map<String, String> map;
            list = new ArrayList<>();

            for (int i = 1; i <= row; i++) {
                map = new HashMap<>();
                for (int j = 0; j < lastColumn; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }
        }
        /* when we use these custom exceptions it will stop our program whenever we get any exception
        meaning if we get FileNotFoundException, it will not try to perform further operations mentioned
        try block. even it is not sensible to further operations. */
        catch (FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("Excel File is Not available, Please check path or Name of file is correct");
        }
        catch (IOException e1){
            e1.printStackTrace();
            throw new RuntimeException("There is an issue in Reading data from the Excel File.");
        }
        return list;
    }

}
