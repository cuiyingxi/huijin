package com.huijin.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.*;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 多维excel解析
 */
@Controller
@RequestMapping("/mult")
public class MultExcelController {

    @GetMapping("/getJsonBySheetConfig")
    @ResponseBody
    public ResponseEntity<String> getJsonBySheetConfig(String excelName, String sheetConfigStr) {
        // 读取json文件
        String filePath = "D:\\cyx\\绘锦工作室\\";
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            filePath = "/home/webDemo/files/";
        }
        Map<String, String> result = new HashMap<>();
        try {
            if (StringUtils.isNotBlank(sheetConfigStr)) {
                File file = new File(filePath + excelName);
                if (file.exists()) {
                    InputStream inputStream = new FileInputStream(file);
                    Workbook workbook = WorkbookFactory.create(inputStream);

                    String[] sheetConfigList = sheetConfigStr.split(";");
                    for (String sheetConfig : sheetConfigList) {
                        String[] strings = sheetConfig.split(":");
                        String sheetName = strings[0];
                        int titleIndex = Integer.parseInt(strings[1]);
                        String colIndexStr = strings[2];
                        String[] colIndexArr = colIndexStr.split(",");
                        JSONArray jsonArray = new JSONArray();
                        Sheet sheet = workbook.getSheet(sheetName);
                        // 标题list
                        List<String> titleList = new ArrayList<>();

                        for (Row row : sheet) {

                            if (row.getRowNum() < (titleIndex - 1)) {
                                continue;
                            }
                            if (row.getRowNum() == (titleIndex - 1)) { // 标题行
                                for (String colIndex : colIndexArr) {
                                    Cell cell = row.getCell(getColumnNumber(colIndex) - 1);
                                    titleList.add(cell.getStringCellValue());
                                }
                            }
                            if (row.getRowNum() > (titleIndex - 1)) { // 数据行
                                JSONObject jsonObject = new JSONObject();
                                for (int j = 0; j < colIndexArr.length; j++) {
                                    String title = titleList.get(j);
                                    Cell dataCell = row.getCell(getColumnNumber(colIndexArr[j]) - 1);
                                    DataFormatter dataFormatter = new DataFormatter();
                                    String value = dataFormatter.formatCellValue(dataCell);
                                    jsonObject.put(title, value);
                                }
                                jsonArray.add(jsonObject);
                            }
                        }

                        result.put(sheetName, jsonArray.toJSONString());

                    }
                } else {
                    System.out.println("The file does not exist, please check if the file name and path are correct!");
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject resultJson = new JSONObject();
        resultJson.put("data", result);
        return ResponseEntity.ok(resultJson.toJSONString());
    }

    private static int getColumnNumber(String columnName) {
        columnName = columnName.toUpperCase();
        int result = 0;
        int pow = 0;
        for (int i = columnName.length() - 1; i >= 0; i--) {
            char ch = columnName.charAt(i);
            int digit = ch - 'A' + 1;
            result += digit * Math.pow(26, pow);
            pow++;
        }
        return result;
    }

}
