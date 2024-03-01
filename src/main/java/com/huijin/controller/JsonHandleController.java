package com.huijin.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.*;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * json格式数据上传并保存以及读取
 */
@RestController
public class JsonHandleController {

    @GetMapping("/getExcelJson")
    @ResponseBody
    public ResponseEntity<String> getExcelJson(String excelName, int titleIndex, int colunmCounts) {
        // 读取json文件
        String filePath = "E:\\绘锦工作室\\excel保存\\";
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            filePath = "/home/webDemo/files/";
        }
        String filePathAndName = filePath + excelName;
        File file = new File(filePathAndName);
        JSONArray jsonArray = new JSONArray();
        try {
            FileInputStream inputStream = new FileInputStream(file);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            List<String> titleList = new ArrayList<>();

            for (Row row : sheet) {
                if (row.getRowNum() < (titleIndex - 1)) {
                    continue;
                }
                if (row.getRowNum() == (titleIndex - 1)) { // 标题行
                    for (int i = 0; i < colunmCounts; i++) {
                        Cell cell = row.getCell(i);
                        titleList.add(cell.getStringCellValue());
                    }
                }
                if (row.getRowNum() > (titleIndex - 1)) { // 数据行
                    JSONObject jsonObject = new JSONObject();
                    for (int j = 0; j < colunmCounts; j++) {
                        String title = titleList.get(j);
                        Cell dataCell = row.getCell(j);
                        DataFormatter dataFormatter = new DataFormatter();
                        String value = dataFormatter.formatCellValue(dataCell);
                        jsonObject.put(title, value);
                    }
                    jsonArray.add(jsonObject);
                }
            }
            inputStream.close();
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.ok("file not found!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.ok("excel parse error!");
        }
        JSONObject result = new JSONObject();
        result.put("data", jsonArray);
        return ResponseEntity.ok(result.toJSONString());
    }

    @GetMapping("/getJson")
    @ResponseBody
    public ResponseEntity<String> getJson(String jsonname) {
        if (StringUtils.isBlank(jsonname)) {
            return ResponseEntity.ok("jsonname is null!");
        }
        // 读取json文件
        String filePathAndName = "";
        String filePath = "E:\\绘锦工作室\\jsonfiles\\";
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            filePath = "/home/webDemo/jsonfiles/";
        }
        filePathAndName = filePath + jsonname + ".json";
        StringBuilder lineStr = new StringBuilder();
        try (Stream<String> lines = Files.lines(Paths.get(filePathAndName), StandardCharsets.UTF_8)) {
            lines.forEach(lineStr::append);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.ok("get json error!");
        }
        System.out.println("jsonname:" + jsonname + "的结果：" + lineStr.toString());
        return ResponseEntity.ok(lineStr.toString());
    }

    @GetMapping("/saveJsonByGet")
    @ResponseBody
    public ResponseEntity<String> saveJsonByGet(String jsonStr, String jsonname) {
        return saveJson(jsonStr, jsonname);
    }

    @PostMapping("/saveJsonByPost")
    @ResponseBody
    public ResponseEntity<String> saveJsonByPost(String jsonStr, String jsonname) {
        return saveJson(jsonStr, jsonname);
    }


    private ResponseEntity<String> saveJson(String jsonStr, String jsonname) {
        if (StringUtils.isBlank(jsonname)) {
            return ResponseEntity.ok("json名称是空!");
        }
        if (StringUtils.isBlank(jsonStr)) {
            return ResponseEntity.ok("json 内容是空!");
        }
        // 将json文件保存到文件中
        String filePath = "E:\\绘锦工作室\\jsonfiles\\";
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            filePath = "/home/webDemo/jsonfiles/";
        }
        File filePath1 = new File(filePath);
        if (!filePath1.exists()) {
            filePath1.mkdirs();
        }

        filePath += (jsonname + ".json");
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            // 清空源文件内容
            FileWriter writer = new FileWriter(filePath); // 创建FileWriter对象
            writer.write(""); // 先将文件内容清空为空字符串
            writer.flush();
            writer.close(); // 关闭writer流
            if (StringUtils.isNotBlank(jsonStr)) {

                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8"); // 创建FileWriter对象
                outputStreamWriter.write(jsonStr); // 先将文件内容清空为空字符串
                outputStreamWriter.flush();
                outputStreamWriter.close(); // 关闭writer流
                System.out.println("已经将字符串保存至文件！");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.ok("保存json失败!");
        }
        return ResponseEntity.ok("保存json成功");
    }

}
