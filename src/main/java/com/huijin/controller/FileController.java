package com.huijin.controller;

import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件操作controller
 */
@Controller
@RequestMapping("/fileapi")
public class FileController {

    /**
     * 上传图片
     */
    @PostMapping("/uploadImg")
    @ResponseBody
    public String uploadImg(MultipartFile file) throws IOException {
        if (file == null || StringUtils.isBlank(file.getOriginalFilename())) {
            return "{\"code\":999,\"message\":\"file is null\"}";
        }
        // 如果是windows 则是D://webDemo/huijin_1_file/imgfile
        // 如果是linux 则是/home/webDemo/huijin_1_file/imgfile
        String osName = System.getProperty("os.name").toLowerCase();

        String path = "/home/webDemo/huijin_1_file/imgfile";

        String realPath = path;
        if (osName.contains("win")) {
            path = path.replace("home", "D:").replace('/', '\\');
            realPath = path.substring(1);
        }
        //用于查看路径是否正确
        System.out.println(realPath);

        // 文件保存
        File f1 = new File(realPath);
        if (!f1.exists()) {  // 不存在，则创建该文件夹
            f1.mkdir();
        }
        String realPath1 = f1.getCanonicalPath();
        // 上传该文件/图像至该文件夹下
        file.transferTo(new File(realPath1 + File.separator + file.getOriginalFilename()));
        return "{\"code\":200,\"message\":\"success\"}";
    }

    /**
     * 下载图片
     */
    @GetMapping("/downloadImg")
    @ResponseBody
    public void downloadImg(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (fileName == null || StringUtils.isBlank(fileName)) {
            return;
        }
        // 如果是windows 则是D://webDemo/huijin_1_file/imgfile
        // 如果是linux 则是/home/webDemo/huijin_1_file/imgfile
        String osName = System.getProperty("os.name").toLowerCase();

        String path = "/home/webDemo/huijin_1_file/imgfile";

        String realPath = path;
        if (osName.contains("win")) {
            path = path.replace("home", "D:").replace('/', '\\');
            realPath = path.substring(1);
        }
        //用于查看路径是否正确
        System.out.println(realPath);

        // 文件下载
        OutputStream os = null;
        try {
            // 读取图片
            BufferedImage image = ImageIO.read(new FileInputStream(realPath + File.separator + fileName));
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


}
