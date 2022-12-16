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
    private ExcelUtils() throws Exception {}

    public static List<Map<String, String>> getTestData(String sheetName){
        List<Map<String, String>> list = null;
        FileInputStream fis = null;
        try {
            fis= new FileInputStream(FrameworkConstants.getExcelpath());
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int row = sheet.getLastRowNum();
            int lastcolomn = sheet.getRow(0).getLastCellNum();

            Map<String, String> map;
            list = new ArrayList<>();

            for (int i = 1; i <= row; i++) {
                map = new HashMap<>();
                for (int j = 0; j < lastcolomn; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e1){
            e1.printStackTrace();
        }
        finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

}
