package com.huijin.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.*;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/update")
    public String hello(Model model) {
        return "hello";
    }

    @PostMapping("/uploadExcelAndSave")
    @ResponseBody
    public String uploadExcelAndSave(MultipartFile file) throws IOException {
        return saveFile(file);
    }


    @PostMapping("/uploadImgAndSave")
    @ResponseBody
    public String uploadImgAndSave(MultipartFile file) throws IOException {
        return saveImgFile(file);
    }

    @GetMapping("getImg")
    public void getImg(String imgName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        OutputStream os = null;
        try {
            String path = ResourceUtils.getURL("classpath:").getPath() + "static/images/uploadImg";
            String osName = System.getProperty("os.name").toLowerCase();
            String realPath = path;
            if (osName.contains("win")) {
                realPath = path.replace('/', '\\').substring(1, path.length());
            }


            // 读取图片
            BufferedImage image = ImageIO.read(new FileInputStream(new File(realPath + File.separator + imgName)));
            response.setContentType("image/png");
            os = response.getOutputStream();
            if (image != null) {
                ImageIO.write(image, "png", os);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                os.flush();
                os.close();
            }
        }
    }

    private String saveImgFile(MultipartFile file) throws IOException {
        if (file == null || StringUtils.isBlank(file.getOriginalFilename())) {
            return "{\"code\":999,\"message\":\"file is null\"}";
        }
        String path = ResourceUtils.getURL("classpath:").getPath() + "static/images/uploadImg";
        String osName = System.getProperty("os.name").toLowerCase();
        String realPath = path;
        if (osName.contains("win")) {
            realPath = path.replace('/', '\\').substring(1, path.length());
        }
        //用于查看路径是否正确
        System.out.println(realPath);
        System.out.println("-------------------------11111111");

        // 文件保存
        String fileName = file.getOriginalFilename();
        File f1 = new File(realPath);
        if (!f1.exists()) {  // 不存在，则创建该文件夹
            f1.mkdir();
        }
        String realPath1 = f1.getCanonicalPath();
        // 上传该文件/图像至该文件夹下
        file.transferTo(new File(realPath1 + File.separator + file.getOriginalFilename()));
        return "{\"code\":200,\"message\":\"success\"}";
    }


    private String saveFile(MultipartFile file) throws IOException {
        if (file == null || StringUtils.isBlank(file.getOriginalFilename())) {
            return "{\"code\":999,\"message\":\"file is null\"}";
        }
        // 文件保存
        String fileName = file.getOriginalFilename();
        String filePath = "E:\\绘锦工作室\\excel保存\\";
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            filePath = "/home/webDemo/files/";
        }
        System.out.println("fileName:" + fileName);
        File file1 = new File(filePath + fileName);
        OutputStream outputStream = new FileOutputStream(file1);
        InputStream inputStream = file.getInputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        outputStream.close();
        inputStream.close();

        return "{\"code\":200,\"message\":\"success\"}";
    }


    @PostMapping("/uploadExcelAndParse")
    public String uploadExcelAndParse(MultipartFile file, int titleIndex, int colunmCounts, Model model) throws IOException {
        if (file == null || StringUtils.isBlank(file.getOriginalFilename())) {
            return "file is null";
        }
        // 文件保存
        InputStream inputStream = file.getInputStream();

        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheetAt(0);
        List<String> titleList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray();
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
        model.addAttribute("userJson", jsonArray.toJSONString());
        return "success";
    }
}
